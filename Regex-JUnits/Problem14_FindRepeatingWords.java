
import java.util.regex.*;
import java.util.*;

public class Problem14_FindRepeatingWords {
    // Finds adjacent repeated words like "is is", "repeated repeated"
    private static final Pattern REPEAT = Pattern.compile("\\b(\\w+)\\b(?:\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);

    public static Set<String> findRepeats(String text) {
        Matcher m = REPEAT.matcher(text);
        Set<String> out = new LinkedHashSet<>(); // keep order of first appearance
        while (m.find()) out.add(m.group(1).toLowerCase());
        return out;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> reps = findRepeats(text);
        // Print in example style (lowercase ok; could also capitalize)
        System.out.println(String.join(", ", reps));
    }
}
