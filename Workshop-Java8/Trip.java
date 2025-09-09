
import java.time.LocalDateTime;

public class Trip {
    private final String route;
    private final String serviceId;
    private final Passenger passenger;
    private final double fare;
    private final LocalDateTime timestamp;
    private final boolean peak;

    public Trip(String route, String serviceId, Passenger passenger, double fare, LocalDateTime timestamp, boolean peak) {
        this.route = route;
        this.serviceId = serviceId;
        this.passenger = passenger;
        this.fare = fare;
        this.timestamp = timestamp;
        this.peak = peak;
    }

    public String getRoute() { return route; }
    public String getServiceId() { return serviceId; }
    public Passenger getPassenger() { return passenger; }
    public double getFare() { return fare; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isPeak() { return peak; }

    @Override public String toString() {
        return String.format("Trip[%s via %s by %s fare=%.2f peak=%s]", route, serviceId, passenger, fare, peak);
    }
}
