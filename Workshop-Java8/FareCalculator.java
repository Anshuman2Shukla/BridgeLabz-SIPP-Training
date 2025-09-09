
@FunctionalInterface
public interface FareCalculator {
    double calculateFare(double baseFare, double distanceKm, boolean peak);
    // can be implemented with a lambda
}
