# ConsoleApp – Gehtsoft Technical Assessment Report

## 💻 Project Description
This repository contains a Java console application created for the Gehtsoft Training Program entrance assignment.  
The project implements two core functionalities:

1. **Caesar Cipher Encryption/Decryption** – Supports both Russian (including Cyrillic letters with Ё/ё) and English alphabets. The cipher preserves letter case and leaves non-alphabetic characters unchanged. Decryption can be done with a known shift or by brute-force guessing the shift value with candidate output suggestions.
3. **Arithmetic Expression Evaluator** – Parses and evaluates mathematical expressions with support for addition, subtraction, multiplication, division, parentheses, and desimal numbers. Includes error handling for invalid expressions and division by zero.

## 🛠️ Technologies
- Java 17 (standard libraries only)
- Console/terminal input and output
- Modular code with clear separation of concerns (different classes for CaesarCipher and ArithmeticEval)

## ⚙️ How to Compile and Run

## For MacOS/Linux
1. Compile all Java files, e.g.:
   ```bash  
   javac -d out src/**/*.java
2. Run the Main class:
   ```bash
   java -cp out Main

## For Windows (cmd):
1. Generate list of Java files and compile:
   ```cmd
   dir /s /b src\*.java > sources.txt
   javac -d out @sources.txt
2. Run the application:
   ```cmd
   java -cp out Main

## For Windows (PowerShell):
1. Compile all Java files recursively:
  ```powershell
  Get-ChildItem -Path src -Filter *.java -Recurse | ForEach-Object { $_.FullName } | Set-Content sources.txt
  javac -d out @sources.txt
```
2. Run the application:
  ```powershell
  java -cp out Main
 
 ```
## 💡 My Approach and Assumptions
- Caesar Cipher: Implemented full support for Russian and English alphabets, including wrap-around and case preservation. For decryption without a known shift, brute-force tries all possible shifts and presents candidates to the user for selection.
- Arithmetic Evaluator: Used tokenization, conversion to Reverse Polish Notation (RPN), and evaluation using a stack. Supports floating-point and negative numbers, as well as proper operator precedence and parentheses.
- Error Handling: Input errors (invalid shift, empty files, invalid expressions) are handled gracefully with user-friendly messages.
- User Interface: Simple console menu guiding the user through available operations with clear prompts and results.

## 📊 Examples of Usage

## 📂 Project Structure
ConsoleApp/
- src/
   - Main.java                
   - caesar/
     - CaesarCipher.java
   - arithmetic/
     - ArithmeticEval.java
   - reading/
     - Reading.java
   - testdata/
     - input_eng.txt
     - input_rus.txt
     - input_num.txt
   - out/
   - README.md
   - .gitignore
 
