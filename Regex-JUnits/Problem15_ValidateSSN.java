
import java.util.regex.*;

public class Problem15_ValidateSSN {
    private static final Pattern SSN = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");

    public static boolean isValid(String s) {
        return SSN.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {"123-45-6789", "123456789", "000-00-0000"};
        for (String t : tests) {
            System.out.printf("%s -> %s%n", t, isValid(t) ? "Valid" : "Invalid");
        }
    }
}
