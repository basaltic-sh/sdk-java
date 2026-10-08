#!/usr/bin/env python3
"""Publish only the reviewed public GitHub tag using its protected environment."""
import os
from pathlib import Path
import re
import subprocess
import tempfile
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parents[1]
if os.environ.get("GITHUB_ACTIONS") != "true" or os.environ.get("GITHUB_REPOSITORY") != "basaltic-sh/sdk-java" or os.environ.get("GITHUB_REF_TYPE") != "tag":
    raise SystemExit("Publication must run from the public GitHub release tag")
version = ET.parse(ROOT / "pom.xml").getroot().findtext("{http://maven.apache.org/POM/4.0.0}version")
if os.environ.get("GITHUB_REF_NAME") != "v" + version:
    raise SystemExit("Tag and package version differ")
# Central's staging plugin currently includes local resolver metadata under Maven
# 3.10. Keep publication on the version whose signed bundle is verified in CI.
maven_version = subprocess.check_output(["mvn", "-B", "-ntp", "--version"], text=True)
maven_version = re.sub(r"\x1b\[[0-9;]*m", "", maven_version)
if not re.search(r"(?m)^Apache Maven 3\.9\.16(?:\s|$)", maven_version):
    raise SystemExit("Publication requires the verified Maven 3.9.16 toolchain")
for key in ("CENTRAL_USERNAME", "CENTRAL_PASSWORD", "MAVEN_GPG_KEY", "MAVEN_GPG_PASSPHRASE"):
    if not os.environ.get(key):
        raise SystemExit("Missing protected publishing credential: " + key)
expected = os.environ.get("GITHUB_SHA", "")
actual = subprocess.check_output(["git", "-c", "safe.directory=" + str(ROOT), "rev-parse", "HEAD"], cwd=ROOT, text=True).strip()
if not expected or actual != expected:
    raise SystemExit("Checkout does not match the public workflow commit")
subprocess.run(["git", "-c", "safe.directory=" + str(ROOT), "diff", "--exit-code"], cwd=ROOT, check=True)
with tempfile.TemporaryDirectory(prefix="basaltic-central-", dir=os.environ.get("RUNNER_TEMP")) as tmp:
    settings = ET.Element("settings", xmlns="http://maven.apache.org/SETTINGS/1.2.0")
    server = ET.SubElement(ET.SubElement(settings, "servers"), "server")
    for key, value in (("id", "central"), ("username", os.environ["CENTRAL_USERNAME"]), ("password", os.environ["CENTRAL_PASSWORD"])):
        ET.SubElement(server, key).text = value
    path = Path(tmp) / "settings.xml"
    path.write_bytes(ET.tostring(settings, encoding="utf-8", xml_declaration=True))
    path.chmod(0o600)
    subprocess.run(["mvn", "-B", "-ntp", "--settings", str(path), "-Pcentral", "-Dcentral.skipPublishing=false", "deploy"], cwd=ROOT, check=True)
