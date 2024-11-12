import java.util.*;
public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Banking Application");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    bankService.registerUser();
                    break;
                case 2:
                    bankService.loginUser();
                    break;
                case 3:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Choose a valid option.");
                    break;
            }
        }
    }
}
