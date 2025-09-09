
import java.util.regex.*;

public class Problem03_ValidateHexColor {
    // # followed by exactly 6 hex chars
    private static final Pattern HEX = Pattern.compile("^#[0-9A-Fa-f]{6}$");

    public static boolean isValid(String s) {
        return HEX.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {"#FFA500", "#ff4500", "#123", "#GGGGGG"};
        for (String t : tests) {
            System.out.printf("%s -> %s%n", t, isValid(t) ? "Valid" : "Invalid");
        }
    }
}
