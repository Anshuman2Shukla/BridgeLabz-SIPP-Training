
import java.util.regex.*;
import java.util.*;

public class Problem04_ExtractEmails {
    private static final Pattern EMAIL = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

    public static List<String> extract(String text) {
        Matcher m = EMAIL.matcher(text);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        System.out.println(String.join("\n", extract(text)));
    }
}
