
import java.time.LocalTime;

public class BusService implements TransportService {
    private final String id;
    private final LocalTime departure;
    private final double baseFare;

    public BusService(String id, LocalTime departure, double baseFare) {
        this.id = id; this.departure = departure; this.baseFare = baseFare;
    }

    public String getId() { return id; }
    public String getType() { return "Bus"; }
    public LocalTime getDeparture() { return departure; }
    public double getBaseFare() { return baseFare; }
}
