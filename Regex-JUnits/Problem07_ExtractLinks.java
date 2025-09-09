
import java.util.regex.*;
import java.util.*;

public class Problem07_ExtractLinks {
    // Basic http(s) URL extractor
    private static final Pattern URL = Pattern.compile("\\bhttps?://[\\w.-]+(?:/[\\w./?%&=+#-]*)?");

    public static List<String> extract(String text) {
        Matcher m = URL.matcher(text);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        System.out.println(String.join(", ", extract(text)));
    }
}
