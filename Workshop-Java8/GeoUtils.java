
public interface GeoUtils {
    // Haversine or simple Euclidean placeholder - static utility in interface
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // simple Pythagorean (not accurate for long distances) for demo purposes
        double dx = lat1 - lat2;
        double dy = lon1 - lon2;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
