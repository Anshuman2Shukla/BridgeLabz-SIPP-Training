
import java.text.SimpleDateFormat;
import java.util.Date;

interface DateUtils {
    static String formatDate(Date d, String pattern) {
        return new SimpleDateFormat(pattern).format(d);
    }
}

public class Problem09_DateFormatUtility {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(DateUtils.formatDate(now, "dd/MM/yyyy"));
        System.out.println(DateUtils.formatDate(now, "yyyy-MM-dd HH:mm:ss"));
    }
}
