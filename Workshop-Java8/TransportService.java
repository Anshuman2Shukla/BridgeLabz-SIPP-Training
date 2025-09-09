
import java.time.LocalTime;
import java.util.Objects;

public interface TransportService {
    String getId();
    String getType();
    LocalTime getDeparture();
    double getBaseFare();
    default void printServiceDetails() {
        System.out.printf("[%s] %s departs at %s, base fare: %.2f\n", getId(), getType(), getDeparture(), getBaseFare());
    }
    // optional override by services
}
