#!/usr/bin/env python3
"""Validate public runtime source without private generators or credentials."""
import os
import subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
subprocess.run(["python3", "scripts/format.py", "--check"], cwd=ROOT, check=True)
subprocess.run([os.environ.get("MAVEN", "mvn"), "-B", "-ntp", "clean", "verify"], cwd=ROOT, check=True)
