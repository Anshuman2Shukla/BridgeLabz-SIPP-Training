
import java.util.regex.*;
import java.util.*;

public class Problem06_ExtractDates_ddMMyyyy {
    // dd/mm/yyyy (basic validation for day/month ranges)
    private static final Pattern DATE = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})\\b");

    public static List<String> extract(String text) {
        Matcher m = DATE.matcher(text);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        System.out.println(String.join(", ", extract(text)));
    }
}
