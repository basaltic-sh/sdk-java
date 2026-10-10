#!/usr/bin/env python3
"""Check release metadata, source correspondence, JAR contents and a clean consumer."""
import hashlib
import json
import os
from pathlib import Path
import re
import subprocess
import tempfile
import xml.etree.ElementTree as ET
import zipfile

ROOT = Path(__file__).resolve().parents[1]
NS = {"m": "http://maven.apache.org/POM/4.0.0"}


def check_install_examples(readme, version):
    # The introductory Maven/Gradle coordinates must install this API surface.
    coordinates = re.findall(r"sh\.basaltic:sdk-java:([0-9A-Za-z.-]+)", readme)
    assert len(coordinates) >= 2 and all(v == version for v in coordinates), "README coordinates must match the release"
    dependencies = [ET.fromstring(block) for block in re.findall(r"```xml\n(.*?)```", readme, re.S)]
    examples = [d for d in dependencies if d.findtext("artifactId") == "sdk-java"]
    assert examples, "README has no Maven installation dependency"
    for dependency in examples:
        assert dependency.findtext("groupId") == "sh.basaltic"
        assert dependency.findtext("version") == version, "README Maven version must match the release"


def main():
    pom = ET.parse(ROOT / "pom.xml").getroot()
    value = lambda path: pom.findtext(path, namespaces=NS)
    assert value("m:groupId") == "sh.basaltic" and value("m:artifactId") == "sdk-java"
    version = value("m:version")
    assert re.fullmatch(r"[0-9]+\.[0-9]+\.[0-9]+(?:-[A-Za-z0-9.]+)?", version)
    assert value("m:url") == "https://github.com/basaltic-sh/sdk-java"
    assert value("m:scm/m:url") == "https://github.com/basaltic-sh/sdk-java"
    assert value("m:scm/m:tag") == "v" + version
    assert value("m:properties/m:maven.compiler.release") == "17"
    assert value("m:developers/m:developer/m:name") == "Basaltic"
    assert len(pom.findall("m:developers/m:developer", NS)) == 1
    if os.environ.get("RELEASE_TAG"): assert os.environ["RELEASE_TAG"] == "v" + version
    client = (ROOT / "src/main/java/sh/basaltic/sdk/Client.java").read_text()
    assert re.search(r'VERSION\s*=\s*"' + re.escape(version) + '"', client)
    check_install_examples((ROOT / "README.md").read_text(), version)
    maven = os.environ.get("MAVEN", "mvn")
    subprocess.run([maven, "-B", "-ntp", "-DskipTests", "package", "dependency:build-classpath", "-DincludeScope=runtime", "-Dmdep.outputFile=target/runtime-classpath.txt"], cwd=ROOT, check=True)
    artifacts = {suffix: ROOT / "target" / ("sdk-java-" + version + suffix + ".jar") for suffix in ("", "-sources", "-javadoc")}
    source = ROOT / "src/main/java"
    expected = {str(p.relative_to(source)): p.read_bytes() for p in source.rglob("*.java")}
    with zipfile.ZipFile(artifacts["-sources"]) as archive:
        names = [n for n in archive.namelist() if not n.endswith("/")]
        assert len(names) == len(set(names))
        actual = {n: archive.read(n) for n in names if n.endswith(".java")}
        assert actual == expected, "Source JAR differs from public Java source"
        for name in names:
            assert name in expected or name.startswith("META-INF/"), name
            assert ".." not in Path(name).parts and not name.startswith("/")
    for suffix, artifact in artifacts.items():
        with zipfile.ZipFile(artifact) as archive:
            for name in archive.namelist():
                assert ".." not in Path(name).parts and not name.startswith("/")
                assert not any(v in name for v in ("AGENTS.md", "CLAUDE.md", "ClientTest", "internal/gen", "test-classes", ".git")), name
                if suffix == "" and not name.endswith("/"):
                    assert name.startswith("sh/basaltic/sdk/") and name.endswith(".class") or name.startswith("META-INF/"), name
                    if name.endswith(".class"):
                        data = archive.read(name)
                        assert data[:4] == b"\xca\xfe\xba\xbe" and int.from_bytes(data[6:8], "big") == 61, "Class does not target Java 17"
            if suffix in ("", "-sources"):
                assert archive.read("META-INF/LICENSE") == (ROOT / "LICENSE").read_bytes()
                assert archive.read("META-INF/SECURITY.md") == (ROOT / "SECURITY.md").read_bytes()
                assert archive.read("META-INF/maven/sh.basaltic/sdk-java/pom.xml") == (ROOT / "pom.xml").read_bytes()
        assert artifact.stat().st_size > 0
    jdk = Path(os.environ["JAVA_HOME"]) / "bin" if os.environ.get("JAVA_HOME") else None
    java, javac = [str(jdk / cmd) if jdk else cmd for cmd in ("java", "javac")]
    classpath = str(artifacts[""]) + os.pathsep + (ROOT / "target/runtime-classpath.txt").read_text().strip()
    with tempfile.TemporaryDirectory(prefix="basaltic-java-consumer-") as tmp:
        dest = Path(tmp)
        consumer = '''import sh.basaltic.sdk.*;
import sh.basaltic.sdk.models.Compute;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
public class Consumer {
 public static void main(String[] args) throws Exception {
  HttpServer server=HttpServer.create(new InetSocketAddress("127.0.0.1",0),0);
  server.createContext("/",exchange->{byte[] body="{\\"image\\":{\\"id\\":\\"from-package\\"}}".getBytes(StandardCharsets.UTF_8);exchange.sendResponseHeaders(200,body.length);exchange.getResponseBody().write(body);exchange.close();});server.start();
  try(Client client=new Client(Config.builder().credentials(Credentials.bearer("fixture-token")).endpoint("compute","http://127.0.0.1:"+server.getAddress().getPort()).build())) {
   Request<Compute.ImageResponse> request=client.compute().getImage("one");
   if(!"from-package".equals(request.sendAsync().join().data().getImage().getId())) throw new AssertionError();
  } finally {server.stop(0);}
 }
}
'''
        (dest / "Consumer.java").write_text(consumer)
        files = [str(dest / "Consumer.java")]
        readme = (ROOT / "README.md").read_text()
        examples = 0
        for snippet in re.findall(r"```java\n(.*?)```", readme, re.S):
            match = re.search(r"public class ([A-Za-z0-9_]+)", snippet)
            assert match, "README Java examples must be standalone compilable classes"
            path = dest / (match[1] + ".java")
            path.write_text(snippet); files.append(str(path)); examples += 1
        assert examples >= 2
        subprocess.run([javac, "--release", "17", "-Xlint:all", "-Werror", "-cp", classpath, *files], check=True)
        subprocess.run([java, "-cp", classpath + os.pathsep + str(dest), "Consumer"], check=True)
    result = {"coordinates": "sh.basaltic:sdk-java:" + version, "source_files": len(expected), "source_bytes_match": True, "class_version": 61, "consumer_passed": True, "readme_examples_compiled": examples, "artifacts": {p.name: hashlib.sha256(p.read_bytes()).hexdigest() for p in artifacts.values()}}
    print(json.dumps(result))


if __name__ == "__main__": main()
