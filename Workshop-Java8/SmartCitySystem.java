
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class SmartCitySystem {
    public static void main(String[] args) throws Exception {
        // Create services
        List<TransportService> services = Arrays.asList(
            new BusService("BUS-101", LocalTime.of(9, 0), 1.50),
            new BusService("BUS-102", LocalTime.of(9, 15), 1.20),
            new MetroService("MET-1", LocalTime.of(8, 45), 1.00),
            new TaxiService("TAXI-7", LocalTime.of(9, 5), 3.00, 12.97, 77.59),
            new FerryService("FER-1", LocalTime.of(10, 0), 2.50),
            new AmbulanceService("AMB-1", LocalTime.now(), 0.0)
        );

        System.out.println("--- Live Services (forEach + method ref) ---");
        // ForEach and method reference to default print
        services.forEach(TransportService::printServiceDetails);

        // Passenger list
        List<Passenger> passengers = Arrays.asList(
            new Passenger("P1","Alice",30),
            new Passenger("P2","Bob",25),
            new Passenger("P3","Charlie",40),
            new Passenger("P4","Dana",22)
        );

        // Fare calculator implemented as lambda (functional interface)
        FareCalculator fareCalc = (base, distance, peak) -> {
            double fare = base + distance * 0.5;
            if (peak) fare *= 1.2;
            return Math.round(fare * 100.0) / 100.0;
        };

        // Simulate trips
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip("R1", "BUS-101", passengers.get(0), fareCalc.calculateFare(1.5, 5.0, false), LocalDateTime.now().minusMinutes(30), false));
        trips.add(new Trip("R1", "BUS-102", passengers.get(1), fareCalc.calculateFare(1.2, 3.0, true), LocalDateTime.now().minusMinutes(20), true));
        trips.add(new Trip("R2", "MET-1", passengers.get(2), fareCalc.calculateFare(1.0, 10.0, true), LocalDateTime.now().minusMinutes(10), true));
        trips.add(new Trip("R2", "TAXI-7", passengers.get(3), fareCalc.calculateFare(3.0, 12.0, false), LocalDateTime.now().minusMinutes(5), false));
        trips.add(new Trip("R1", "BUS-101", passengers.get(1), fareCalc.calculateFare(1.5, 2.0, false), LocalDateTime.now().minusMinutes(2), false));

        // Use Streams + Collectors: group by route
        System.out.println("\n--- Trips grouped by route (groupingBy) ---");
        Map<String, List<Trip>> byRoute = trips.stream().collect(groupingBy(Trip::getRoute));
        byRoute.forEach((route, list) -> {
            System.out.println(route + ":"); list.forEach(t -> System.out.println("  " + t));
        });

        // Partition peak vs non-peak
        System.out.println("\n--- Partition peak vs non-peak (partitioningBy) ---");
        Map<Boolean, List<Trip>> peakPartition = trips.stream().collect(partitioningBy(Trip::isPeak));
        System.out.println("Peak trips: " + peakPartition.get(true).size());
        System.out.println("Non-peak trips: " + peakPartition.get(false).size());

        // Summarize fares
        System.out.println("\n--- Fare summary (summarizingDouble) ---");
        DoubleSummaryStatistics stats = trips.stream().collect(summarizingDouble(Trip::getFare));
        System.out.println("Total fares: " + stats.getSum() + ", Average: " + stats.getAverage() + ", Count: " + stats.getCount());

        // Revenue per service (summingDouble)
        System.out.println("\n--- Revenue per service (groupingBy + summingDouble) ---");
        Map<String, Double> revenueByService = trips.stream().collect(groupingBy(Trip::getServiceId, summingDouble(Trip::getFare)));
        revenueByService.forEach((sid, rev) -> System.out.println(sid + " -> " + rev));

        // Top-used route
        System.out.println("\n--- Top used route ---");
        String topRoute = byRoute.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().size()))
            .map(Map.Entry::getKey).orElse("N/A");
        System.out.println("Top route: " + topRoute);

        // Filter & sort using lambdas (e.g., services available before 9:10 sorted by fare)
        System.out.println("\n--- Filter & Sort services before 09:10 by fare (lambda) ---");
        services.stream()
            .filter(s -> s.getDeparture().isBefore(LocalTime.of(9,10)))
            .sorted(Comparator.comparingDouble(TransportService::getBaseFare))
            .forEach(TransportService::printServiceDetails);

        // Demonstrate EmergencyService marker usage
        System.out.println("\n--- Emergency services (marker interface) ---");
        services.stream()
            .filter(s -> s instanceof EmergencyService)
            .forEach(s -> System.out.println("Emergency: " + s.getId() + " type=" + s.getType()));

        // Simulated dashboard update using forEach
        System.out.println("\n--- Dashboard live update (forEach) ---");
        services.forEach(s -> System.out.println("[Dashboard] " + s.getType() + " " + s.getId() + " next at " + s.getDeparture()));

        // Example of adding a new service type dynamically (FerryService already exists)
        System.out.println("\n--- Adding new FerryService demonstrates extensibility ---");
        TransportService ferry = new FerryService("FER-2", LocalTime.of(11,30), 2.75);
        ferry.printServiceDetails();
    }
}
