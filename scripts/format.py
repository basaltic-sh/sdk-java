#!/usr/bin/env python3
"""Use a checksum-pinned official formatter independently of the SDK's target JDK."""
import argparse
import hashlib
import os
from pathlib import Path
import platform
import subprocess
import urllib.request

ROOT = Path(__file__).resolve().parents[1]
VERSION = '1.37.0'
ASSETS = {
    ('Linux', 'x86_64'): ('google-java-format_linux-x86-64', '881821ffd1a52b175886c4ebeeacce2ba5b5d7326b52d32a18d384d8a783bd77'),
    ('Linux', 'aarch64'): ('google-java-format_linux-arm64', 'e8c1c4ae92f5a86367500d78ff0d09ad12bf8ad213fa35b372468fcabf281bd3'),
    ('Darwin', 'arm64'): ('google-java-format_darwin-arm64', '657cf1011c8dfb7e0dac08516db02b701436e59600b961077f83b89b69cc3495'),
    ('Windows', 'AMD64'): ('google-java-format_windows-x86-64.exe', '48260bed87f6830bae44a7a27f66ce98f7d9fb245f500021bd7ae16c9e2daa06'),
}
JAR = ('google-java-format-1.37.0-all-deps.jar', '834b2a0c38cb774953322a84b5ca3f2f40dd3156650b3cd44d3b744345962f7a')


def format_sources(root, check=False):
    native = (platform.system(), platform.machine()) in ASSETS
    name, checksum = ASSETS.get((platform.system(), platform.machine()), JAR)
    executable = ROOT / '.tools' / VERSION / name
    executable.parent.mkdir(parents=True, exist_ok=True)
    if not executable.exists():
        url = f'https://github.com/google/google-java-format/releases/download/v{VERSION}/{name}'
        data = urllib.request.urlopen(url, timeout=60).read()
        if hashlib.sha256(data).hexdigest() != checksum:
            raise ValueError('Formatter checksum mismatch')
        executable.write_bytes(data)
        if native: executable.chmod(0o755)
    if hashlib.sha256(executable.read_bytes()).hexdigest() != checksum:
        raise ValueError('Formatter checksum mismatch')
    if native:
        command = [str(executable)]
    else:
        # Unlisted platforms need JDK 21+ for formatting only; compilation still targets 17.
        home = os.environ.get('FORMAT_JAVA_HOME') or os.environ.get('JAVA_HOME')
        java = str(Path(home) / 'bin/java') if home else 'java'
        command = [java, '-jar', str(executable)]
    files = sorted(str(p) for p in Path(root).glob('src/**/*.java'))
    for offset in range(0, len(files), 100):
        subprocess.run([*command, *(['--dry-run', '--set-exit-if-changed'] if check else ['--replace']), *files[offset:offset+100]], check=True)


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('--check', action='store_true')
    args = parser.parse_args()
    format_sources(ROOT, args.check)
