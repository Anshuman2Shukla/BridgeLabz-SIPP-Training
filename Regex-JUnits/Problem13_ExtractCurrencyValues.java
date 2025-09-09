
import java.util.regex.*;
import java.util.*;

public class Problem13_ExtractCurrencyValues {
    // Dollar-optional amounts with exactly two decimals, e.g., $45.99 or 10.50
    private static final Pattern MONEY = Pattern.compile("\\b\\$?\\d+\\.\\d{2}\\b");

    public static List<String> extract(String text) {
        Matcher m = MONEY.matcher(text);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        System.out.println(String.join(", ", extract(text)));
    }
}
