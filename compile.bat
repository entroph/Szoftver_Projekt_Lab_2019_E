@echo off
javac -encoding UTF-8 -d skeleton src\*.java
jar cmf src\META-INF\MANIFEST.MF Proto.jar skeleton\*.class
pause
@echo Compiled successfully