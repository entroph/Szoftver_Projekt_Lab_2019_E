@echo off
set path=%path%;C:\Program Files\Java\jdk-11.0.2\bin
javac -encoding UTF-8 -d . src\skeleton\*.java
jar cvmf manifest.mf PandaPlaza.jar skeleton\*.class
@echo Install Successful
set /p temp=Press any key to continue! 