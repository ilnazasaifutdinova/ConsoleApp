@echo off
echo Compiling Java project...

::Create folder for .class files (if it doesn't exist)
if not exist out mkdir out

::Compile from src/
javac -d out src\caesar\*.java src\arithmetic\*.java src\reading\*.java src\Main.java

::Checking for successful compilation
if %errorlevel% equ 0 (
    echo Compilation successful.
    echo Running...
    java -cp out Main
) else (
    echo Compilation failed.
)
