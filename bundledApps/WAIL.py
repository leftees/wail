#!/usr/bin/env python
#-*- coding:utf-8 -*-

# Web Archiving Integration Layer (WAIL)
#  This tool ties together web archiving applications including Wayback,
#   Heritrix, and Tomcat.
#  Mat Kelly <wail@matkelly.com> 2013

import wx
import subprocess
import shlex
import webbrowser
import os
import time
import sys
import datetime
import urllib
import urllib2
import base64
import glob
import re
import ssl
import shutil
import errno
from urlparse import urlparse

