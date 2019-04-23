@echo off
javac -encoding UTF-8 -d . src\*.java
jar cmf src\META-INF\MANIFEST.MF Proto.jar .\*.class
pause
@echo Compiled successfully