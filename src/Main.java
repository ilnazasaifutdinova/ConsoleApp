import arithmetic.ArithmeticEval;
import caesar.CaesarCipher;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Gehtsoft Technical Assessment");

        boolean key = true;
        while(key) {
            System.out.println("Please choose an option:");
            System.out.println("1. Caesar Cipher Encryption");
            System.out.println("2. Caesar Cipher Decryption");
            System.out.println("3. Arithmetic Expression Evaluation");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            String selectedNum = scanner.nextLine();

            if (selectedNum.equals("4")) {
                System.out.println("Goodbye!");
                key = false;
                break;
            } else if (selectedNum.equals("1") || selectedNum.equals("2") || selectedNum.equals("3")) {
                System.out.println("Read from file? y/n: ");
                String choice = scanner.nextLine();

                String input;
                if (choice.equals("y")) {
                    System.out.println("Enter path to file: ");
                    String path = scanner.nextLine();
                    input = CaesarCipher.readFile(path); //readFile method will read info from file
                } else {
                    System.out.println("Enter input: ");
                    input = scanner.nextLine();
                }

                switch (selectedNum) {
                    case "1":
                        //Caesar Cipher Encryption
                        System.out.println("Enter shift value: ");
                        int shiftEnc = scanner.nextInt(); //redo
                        scanner.nextLine();
                        String resultEnc = CaesarCipher.encrypt(input, shiftEnc);
                        System.out.println("Result: " + resultEnc);
                        break;
                    case "2":
                        //Caesar Cipher Encryption
                        System.out.println("Enter shift value: ");
                        int shiftDec = scanner.nextInt(); //redo
                        scanner.nextLine();
                        String resultDec = CaesarCipher.decrypt(input, shiftDec);
                        System.out.println("Result: " + resultDec);
                        break;
                    case "3":
                        //Arithmetic Expression Evaluation
                        System.out.println("In progress");
                        break;
                    case "4":
                        System.out.println("Goodbye!");
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please, choose from 1 to 4.");
            }

            System.out.println("\nContinue? y/n: ");
            String check = scanner.nextLine();
            if (check.equals("n")) {
                key = false;
                System.out.println("Goodbye!");
            }
        }
        scanner.close();
    }
}