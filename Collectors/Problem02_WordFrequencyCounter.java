import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Problem02_WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "hello world hello java java world world";
        String[] words = paragraph.split(" ");

        Map<String, Long> frequency = Arrays.stream(words)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequency);
    }
}