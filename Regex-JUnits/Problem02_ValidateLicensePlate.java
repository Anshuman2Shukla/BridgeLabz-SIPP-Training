
import java.util.regex.*;

public class Problem02_ValidateLicensePlate {
    // Two uppercase letters followed by four digits, e.g., AB1234
    private static final Pattern PLATE = Pattern.compile("^[A-Z]{2}\\d{4}$");

    public static boolean isValid(String s) {
        return PLATE.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {"AB1234", "A12345", "ZZ0000", "ab1234"};
        for (String t : tests) {
            System.out.printf("%s -> %s%n", t, isValid(t) ? "Valid" : "Invalid");
        }
    }
}
