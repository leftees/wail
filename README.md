Web Archiving Integration Layer (WAIL)
====
<i>"One-Click User Instigated Preservation"</i>

Web Archiving Integration Layer (WAIL) is a graphical user interface (GUI) atop multiple web archiving tools intended to be used as an easy way for anyone to preserve and replay web pages.

Tools included and accessible through the GUI are Heritrix 3.2.0 and Wayback 2.0.0. Support packages include Apache Tomcat and <a href="https://github.com/pyinstaller/pyinstaller/">pyinstaller</a>.

WAIL is written in Python and compiled to a native executable using the `pyInstaller` package (included).

For more information and to download a binary, see http://matkelly.com/wail .

<h2>Running WAIL</h2>
End-user execution is meant to be accessed through the binary file, either WAIL.app on MacOS X or WAIL.exe on Windows (7+).
To run it using Python for testing, run the following from the root of the WAIL source directory:
<blockquote>python ./bundledApps/WAIL.py</blockquote>

Since Wayback and Heritrix configurations rely on absolute paths on the system, checks and interactions with services may not work in debugging mode unless a binary of WAIL currently exists in directory specific to your operating system (see below).

You may need to install other dependencies on your system to compile from source like <a href="http://www.wxwidgets.org/">wxWidgets</a> depending on your local python configuration.

Python is not required to be installed for end-users, just double-click (above) and go!

<h2>Compiling</h2>
To compile WAIL to a system-dependent executable, `cd` into the root of the WAIL source directory then:
<h3>MacOS X</h3>
<blockquote>sh ./bundledApps/MAKEFILE.sh</blockquote>
This will create /Applications/WAIL.app on MacOS X.

<h3>Windows</h3>
From the Windows shell:
<blockquote>"./bundledApps/MAKEFILE.bat"</blockquote>
then move the WAIL source directory to the root of your C drive (thus making C:\WAIL\).
