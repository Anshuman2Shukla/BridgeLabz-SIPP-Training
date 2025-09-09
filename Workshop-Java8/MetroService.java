
import java.time.LocalTime;

public class MetroService implements TransportService {
    private final String id;
    private final LocalTime departure;
    private final double baseFare;

    public MetroService(String id, LocalTime departure, double baseFare) {
        this.id = id; this.departure = departure; this.baseFare = baseFare;
    }

    public String getId() { return id; }
    public String getType() { return "Metro"; }
    public LocalTime getDeparture() { return departure; }
    public double getBaseFare() { return baseFare; }
    // override default if needed
    @Override
    public void printServiceDetails() {
        System.out.printf("[METRO] %s at %s (fare %.2f) - Fast and frequent\n", id, departure, baseFare);
    }
}
