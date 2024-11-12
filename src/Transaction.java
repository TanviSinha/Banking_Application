import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Type: " + type + ", Amount: " + amount + ", Date: " + date;
    }
}
