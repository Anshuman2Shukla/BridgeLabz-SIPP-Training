
import java.util.function.Function;

public class Problem05_StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthChecker = str -> str.length();
        String msg = "Hello, World!";
        int len = lengthChecker.apply(msg);
        System.out.println("Length of message: " + len);
    }
}
