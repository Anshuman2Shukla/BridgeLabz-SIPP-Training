
import java.util.regex.*;
import java.util.*;

public class Problem12_ExtractProgrammingLanguages {
    // Common set including the examples
    private static final Pattern LANGS = Pattern.compile("\\b(?:JavaScript|TypeScript|C\\+\\+|C#|C|Go|Java|Python|Ruby|PHP|Kotlin|Swift|Rust|Scala)\\b");

    public static List<String> extract(String text) {
        Matcher m = LANGS.matcher(text);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println(String.join(", ", extract(text)));
    }
}
