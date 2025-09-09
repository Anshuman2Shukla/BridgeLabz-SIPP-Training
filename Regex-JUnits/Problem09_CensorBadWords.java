
import java.util.regex.*;
import java.util.*;

public class Problem09_CensorBadWords {
    // Censor given bad words with "****" (case-insensitive, whole words)
    public static String censor(String text, List<String> badWords) {
        if (badWords.isEmpty()) return text;
        String joined = String.join("|", badWords.stream()
                .map(Pattern::quote) // escape any regex meta in words
                .toArray(String[]::new));
        Pattern p = Pattern.compile("\\b(?:" + joined + ")\\b", Pattern.CASE_INSENSITIVE);
        return p.matcher(text).replaceAll("****");
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> bad = Arrays.asList("damn", "stupid");
        System.out.println(censor(input, bad));
    }
}
