
import java.util.regex.*;

public class Problem10_ValidateIPv4 {
    // Four octets, each 0-255
    private static final String OCTET = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
    private static final Pattern IPV4 = Pattern.compile("^" + OCTET + "\\." + OCTET + "\\." + OCTET + "\\." + OCTET + "$");

    public static boolean isValid(String s) {
        return IPV4.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {"192.168.1.1", "255.255.255.255", "256.100.1.1", "01.2.3.4"};
        for (String t : tests) {
            System.out.printf("%s -> %s%n", t, isValid(t) ? "Valid" : "Invalid");
        }
    }
}
