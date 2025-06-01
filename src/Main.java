import arithmetic.ArithmeticEval;
import caesar.CaesarCipher;
import reading.Reading;
import java.util.Scanner;

// Console-based application for the Gehtsoft technical assessment.
// Provides a basic UI for Caesar Cipher Encryption/Decryption and Arithmetic Expression Evaluation.
// Users can input data via console or from a file. Clean structure and basic error handling included.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();
        ArithmeticEval arithEval = new ArithmeticEval();

        System.out.println("Welcome to Gehtsoft Technical Assessment");

        boolean key = true;
        while(key) {
            System.out.println("Please choose an option:");
            System.out.println("1. Caesar Cipher Encryption");
            System.out.println("2. Caesar Cipher Decryption");
            System.out.println("3. Arithmetic Expression Evaluation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String selectedNum = scanner.nextLine();

            if (selectedNum.equals("4")) {
                System.out.println("Goodbye!");
                key = false;
                break;
            } else if (selectedNum.equals("1") || selectedNum.equals("2") || selectedNum.equals("3")) {
                System.out.print("Read from file? y/n: ");
                String choice = scanner.nextLine();
                String input;
                if (choice.equals("y")) {
                    System.out.print("Enter path to file: ");
                    String path = scanner.nextLine();
                    input = Reading.readFile(path); //readFile method will read info from the file
                    if (input.isEmpty()) {
                        System.out.println("File is empty or file not found");
                        continue;
                    }
                } else if (choice.equals("n")) {
                    System.out.print("Enter input: ");
                    input = scanner.nextLine();
                } else {
                    System.out.println("Invalid choice. Please, choose y/n: ");
                    continue;
                }

                switch (selectedNum) {
                    case "1":
                        //Caesar Cipher Encryption
                        System.out.print("Enter shift value: ");
                        String shiftEncStr = scanner.nextLine(); //String type first, then later after checking for the right input;
                        int shiftEnc;
                        try {
                            shiftEnc = Integer.parseInt(shiftEncStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid shift value. Please, enter a number.");
                            break;
                        }

                        String resultEnc = cipher.encrypt(input, shiftEnc);
                        System.out.println("Result: " + resultEnc);
                        break;
                    case "2":
                        //Caesar Cipher Decryption
                        System.out.print("Do you know the shift value? y/n: "); //check for shift value
                        String shiftValue = scanner.nextLine();
                        if (shiftValue.equals("y")) {
                            System.out.print("Enter shift value: ");
                            String shiftDecStr = scanner.nextLine();
                            int shiftDec;
                            try {
                                shiftDec = Integer.parseInt(shiftDecStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid shift value. Please, enter a number.");
                                break;
                            }
                            String resultDec = cipher.decrypt(input, shiftDec); //decrypt() with shift value
                            System.out.println("Result: " + resultDec);
                        } else if (shiftValue.equals("n")) {
                            var candidates = cipher.decryptCandidates(input);
                            System.out.println("Possible decryptions:");
                            for (var candidate : candidates) {
                                System.out.println("Shift " + candidate.shift + ": " + candidate.text);
                            }
                            System.out.print("Please enter the correct shift value from above: ");
                            String chosenShiftStr = scanner.nextLine();
                            int chosenShift;
                            try {
                                chosenShift = Integer.parseInt(chosenShiftStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Returning to menu.");
                                break;
                            }
                            String finalDecrypted = cipher.decrypt(input, chosenShift);
                            System.out.println("Decryption mode:");
                            System.out.println("Input: \"" + input + "\"");
                            System.out.println("Output: \"" + finalDecrypted + "\", shift: " + chosenShift);
                        } else {
                            System.out.println("Invalid choice. Please, choose y/n.");
                        }
                        break;
                    case "3":
                        //Arithmetic Expression Evaluation
                        try {
                            long resultEval = arithEval.evaluate(input);
                            System.out.println("Result: " + resultEval);
                        } catch (ArithmeticException e) {
                            System.out.println("Error evaluating expression: ");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please, choose from 1 to 4.");
                }
            }

            System.out.print("\nContinue? y/n: ");
            String check = scanner.nextLine();
            switch (check) {
                case "n":
                    System.out.println("Goodbye!");
                    key = false;
                    break;
                case "y":
                    System.out.println("Returning to menu..");
                    break;
                default:
                    System.out.println("Invalid choice. Returning to menu..");
                    break;
            }
        }
        scanner.close();
    }
}