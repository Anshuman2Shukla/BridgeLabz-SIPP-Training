
import java.util.regex.*;

public class Problem11_ValidateCreditCard {
    // Simple brand rules per prompt:
    // Visa: starts with 4, 16 digits total
    // MasterCard: starts with 5, 16 digits total (prompt simplified)
    private static final Pattern VISA = Pattern.compile("^4\\d{15}$");
    private static final Pattern MC   = Pattern.compile("^5\\d{15}$");

    public static String brand(String number) {
        if (VISA.matcher(number).matches()) return "Visa (valid)";
        if (MC.matcher(number).matches()) return "MasterCard (valid)";
        return "Invalid/Other";
    }

    public static void main(String[] args) {
        String[] tests = {"4111111111111111", "5111111111111111", "371111111111111", "6011000000000000"};
        for (String t : tests) {
            System.out.printf("%s -> %s%n", t, brand(t));
        }
    }
}
