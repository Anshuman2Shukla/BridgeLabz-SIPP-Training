
interface Sensitive {}

class BankAccount implements Sensitive {
    String accountNumber;
    BankAccount(String acc) { accountNumber = acc; }
}

public class Problem15_SensitiveDataTagging {
    public static void main(String[] args) {
        BankAccount b = new BankAccount("123-456");
        if (b instanceof Sensitive) {
            System.out.println("This is sensitive data, apply encryption!");
        }
    }
}
