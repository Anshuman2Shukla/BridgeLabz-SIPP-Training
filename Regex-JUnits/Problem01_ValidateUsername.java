
import java.util.regex.*;

public class Problem01_ValidateUsername {
    // Starts with a letter; then 4-14 of letters/digits/underscore (total 5-15)
    private static final Pattern USERNAME = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{4,14}$");

    public static boolean isValid(String s) {
        return USERNAME.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {"user_123", "123user", "us", "Alpha_beta_99", "abcde"};
        for (String t : tests) {
            System.out.printf("%s -> %s%n", t, isValid(t) ? "Valid" : "Invalid");
        }
    }
}
