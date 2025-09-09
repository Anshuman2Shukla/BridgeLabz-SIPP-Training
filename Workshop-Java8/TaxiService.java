
import java.time.LocalTime;

public class TaxiService implements TransportService, GeoUtils {
    private final String id;
    private final LocalTime departure;
    private final double baseFare;
    private final double currentLat;
    private final double currentLon;

    public TaxiService(String id, LocalTime departure, double baseFare, double lat, double lon) {
        this.id = id; this.departure = departure; this.baseFare = baseFare; this.currentLat = lat; this.currentLon = lon;
    }

    public String getId() { return id; }
    public String getType() { return "Taxi"; }
    public LocalTime getDeparture() { return departure; }
    public double getBaseFare() { return baseFare; }

    public double distanceTo(double lat, double lon) {
        return GeoUtils.calculateDistance(currentLat, currentLon, lat, lon);
    }
}
