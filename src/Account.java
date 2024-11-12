import java.util.ArrayList;
import java.util.List;

public class Account {
    public static final double SAVINGS_INTEREST_RATE = 0.03;
    private static int idCounter = 100;
    private final String accountId;
    private String username;
    private String holderName;
    private String accountType;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();


    public Account(String username, String holderName, String accountType, double initialDeposit) {
        this.accountId = String.valueOf(idCounter++);
        this.username = username;
        this.holderName = holderName;
        this.accountType = accountType;
        this.balance = initialDeposit;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }
    public void processTransaction(String type, double amount) {
        if (type.equals("withdrawal") && amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        if (type.equals("withdrawal")) {
            balance -= amount;
        } else if (type.equals("deposit")) {
            balance += amount;
        }

        transactions.add(new Transaction(type, amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
