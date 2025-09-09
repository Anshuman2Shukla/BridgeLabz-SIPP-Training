
import java.util.function.Predicate;

public class Problem04_TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> alert = temp -> temp > 40.0;
        double current = 42.5;
        System.out.println("Temperature " + current + " alert? " + alert.test(current));
    }
}
