@echo off
set path=%path%;C:\Program Files\Java\jdk*\bin
javac -encoding UTF-8 -d . src\skeleton\*.java
jar cmf manifest.mf pandaPlaza.jar skeleton\*.class
pause
@echo Compiled successfully.