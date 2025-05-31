import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
            System.out.println("\nEnter your choice:");

            String selectedNum = scanner.nextLine();

            if (selectedNum.equals("4")) {
                System.out.println("Goodbye!");
                key = false;
                break;
            }

            System.out.println("Option selected: " + selectedNum + " in progress");

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