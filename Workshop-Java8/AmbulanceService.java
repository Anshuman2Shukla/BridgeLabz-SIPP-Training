
import java.time.LocalTime;

public class AmbulanceService implements TransportService, EmergencyService {
    private final String id;
    private final LocalTime departure;
    private final double baseFare;

    public AmbulanceService(String id, LocalTime departure, double baseFare) {
        this.id = id; this.departure = departure; this.baseFare = baseFare;
    }

    public String getId() { return id; }
    public String getType() { return "Ambulance"; }
    public LocalTime getDeparture() { return departure; }
    public double getBaseFare() { return baseFare; }

    @Override
    public void printServiceDetails() {
        System.out.printf("[EMERGENCY] %s ready at %s - priority routing enabled\n", id, departure);
    }
}
