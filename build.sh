#!/bin/bash

echo "Compiling Java project..."

#Create folder for .class files (if it doesn't exist)
mkdir -p out

#Compile from src/
javac -d out src/caesar/*.java src/arithmetic/*.java src/reading/*.java src/Main.java

#Checking for successful compilation
if [ $? -eq 0 ]; then
    echo "Compilation successful."
    echo "Running..."
    java -cp out Main
else
    echo "Compilation failed."
fi
