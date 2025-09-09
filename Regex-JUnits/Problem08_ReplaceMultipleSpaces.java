
public class Problem08_ReplaceMultipleSpaces {
    // Replace runs of 2+ literal spaces with a single space
    public static String normalizeSpaces(String s) {
        return s.replaceAll(" {2,}", " ");
    }

    public static void main(String[] args) {
        String input = "This is  an   example   with multiple   spaces.";
        System.out.println(normalizeSpaces(input));
    }
}
