import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> accountIds = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void addAccount(Account account) {
        accountIds.add(account.getAccountId());
    }

    public String getUsername() {
        return username;
    }
}
