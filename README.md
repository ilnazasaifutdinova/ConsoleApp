# ConsoleApp – Gehtsoft Technical Assessment Report

## 💻 Project Description
This repository contains a Java console application created for the Gehtsoft Training Program entrance assignment.  

The project implements two core functionalities:

1. **Caesar Cipher Encryption/Decryption** – Supports both Russian (including Cyrillic letters with Ё/ё) and English alphabets. The cipher preserves letter case and leaves non-alphabetic characters unchanged. Decryption can be done with a known shift or by brute-force guessing the shift value with candidate output suggestions.
3. **Arithmetic Expression Evaluator** – Parses and evaluates mathematical expressions with support for addition, subtraction, multiplication, division, parentheses, and decimal numbers. Includes error handling for invalid expressions and division by zero.

## 🛠️ Technologies
- Java 17 (standard libraries only)
- Console/terminal input and output
- Modular code with clear separation of concerns (different classes for CaesarCipher and ArithmeticEval)

## ⚙️ How to Compile and Run
## On Windows:
Run the batch script to compile and run the project:
   ```cmd
   build.bat
```
## On MacOS/Linux
Run the shell script to compile and run the project:
```bash
./build.sh
```
Both scripts automatically create the out directory for compiled classes and execute the main application.

## 💡 My Approach and Assumptions
- Caesar Cipher: Implemented full support for Russian and English alphabets, including wrap-around and case preservation. For decryption without a known shift, brute-force tries all possible shifts and presents candidates to the user for selection.
- Arithmetic Evaluator: Used tokenization, conversion to Reverse Polish Notation (RPN), and evaluation using a stack. Supports floating-point and negative numbers, as well as proper operator precedence and parentheses.
- Error Handling: Input errors (invalid shift, empty files, invalid expressions) are handled gracefully with user-friendly messages.
- User Interface: Simple console menu guiding the user through available operations with clear prompts and results.

## 📊 Examples of Usage
## Caesar Cipher Encryption
```plaintext
Enter your choice: 1
Read from file? n
Enter input: Hello World
Enter shift value: 3
Result: Khoor Zruog
```
## Caesar Cipher Decryption with shift
```plaintext
Enter your choice: 2
Read from file? y/n: n
Enter input: Khoor Zruog
Do you know the shift value? y/n: y
Enter shift value: 3
Result: Hello World
```
## Caesar Cipher Decryption without shift (brute-force)
```plaintext
Enter your choice: 2
Read from file? y/n: n
Enter input: Khoor Zruog
Do you know the shift value? y/n: n
Possible decryptions:
Shift 0: Khoor Zruog
Shift 1: Jgnnq Yqtnf
Shift 2: Ifmmp Xpsme
Shift 3: Hello World
...
Please enter the correct shift value from above: 3
Decryption mode:
Input: "Khoor Zruog"
Output: "Hello World", shift: 3
```
## Arithmetic Expression Evaluation
```plaintext
Enter your choice: 3
Read from file? y/n: y
Enter path to file: testdata/input_num.txt
Enter input: 2 + 3 * 4
Result: 14
```

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
 
