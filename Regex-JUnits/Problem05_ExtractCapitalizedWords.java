
import java.util.regex.*;
import java.util.*;

public class Problem05_ExtractCapitalizedWords {
    private static final Pattern CAP = Pattern.compile("\\b[A-Z][a-z]*\\b");

    public static List<String> extract(String text) {
        Matcher m = CAP.matcher(text);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extract(text);
        System.out.println(String.join(", ", words));
    }
}
