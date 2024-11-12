import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void registerUser() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try another one.");
        } else {
            users.put(username, new User(username, password));
            System.out.println("User registered successfully.");
        }
    }

    public void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            userMenu(user);
        } else {
            System.out.println("Invalid Data.");
        }
    }

    private void userMenu(User user) {
        while (true) {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Statement");
            System.out.println("5. Check Balance");
            System.out.println("6. Calculate Interest (Savings Only)");
            System.out.println("7. Logout");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    openAccount(user);
                    break;
                case 2:
                    performTransaction(user, "deposit");
                    break;
                case 3:
                    performTransaction(user, "withdrawal");
                    break;
                case 4:
                    viewStatement(user);
                    break;
                case 5:
                    checkBalance(user);
                    break;
                case 6:
                    calculateInterest(user);
                    break;
                case 7:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void openAccount(User user) {
        System.out.print("Enter account holder's name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter account type (savings/checking): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();

        Account account = new Account(user.getUsername(), holderName, accountType, initialDeposit);
        user.addAccount(account);
        accounts.put(account.getAccountId(), account);

        System.out.println("Account created with account number: " + account.getAccountId());
    }

    public void performTransaction(User user, String type) {
        System.out.print("Enter account number: ");
        String accountId = scanner.nextLine();
        Account account = accounts.get(accountId);

        if (account == null || !account.getUsername().equals(user.getUsername())) {
            System.out.println("Invalid account.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (type.equals("withdrawal") && amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }

        account.processTransaction(type, amount);
        System.out.println("Transaction successful. " + type + " of " + amount);
    }

    public void viewStatement(User user) {
        System.out.print("Enter account number: ");
        String accountId = scanner.nextLine();
        Account account = accounts.get(accountId);

        if (account == null || !account.getUsername().equals(user.getUsername())) {
            System.out.println("Invalid account.");
            return;
        }

        System.out.println("Transaction History:");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }

    public void checkBalance(User user) {
        System.out.print("Enter account number: ");
        String accountId = scanner.nextLine();
        Account account = accounts.get(accountId);

        if (account == null || !account.getUsername().equals(user.getUsername())) {
            System.out.println("Invalid account.");
            return;
        }

        System.out.println("Current Balance: " + account.getBalance());
    }

    public void calculateInterest(User user) {
        System.out.print("Enter account number: ");
        String accountId = scanner.nextLine();
        Account account = accounts.get(accountId);

        if (account == null || !account.getUsername().equals(user.getUsername()) || !account.getAccountType().equals("savings")) {
            System.out.println("Invalid account or not a savings account.");
            return;
        }

        double interest = account.getBalance() * Account.SAVINGS_INTEREST_RATE;
        account.processTransaction("interest", interest);
        System.out.println("Interest of " + interest + " added to the account.");
    }
}
