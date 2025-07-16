import java.util.*;

public class FlightBookingSystem {

    static String[] flights = {
            "AI101 - Delhi to Mumbai",
            "AI102 - Mumbai to Kolkata",
            "AI103 - Bangalore to Delhi",
            "AI104 - Chennai to Hyderabad",
            "AI105 - Kolkata to Pune"
    };

    static List<String> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    System.out.print("Enter search keyword: ");
                    String keyword = sc.nextLine();
                    searchFlights(keyword);
                    break;
                case 2:
                    System.out.println("------------available  flights are-----------");
                    for(String x:flights){
                        System.out.println(x);
                    }
                    System.out.print("Enter Flight Code to Book: ");
                    String code = sc.nextLine();
                    bookFlight(code);
                    break;
                case 3:
                    displayBookings();
                    break;
                case 4:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void searchFlights(String keyword) {
        System.out.println("\nMatching Flights:");
        boolean found = false;
        for (String flight : flights) {
            if (flight.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(flight);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    public static void bookFlight(String code) {
        boolean exists = false;
        for (String flight : flights) {
            if (flight.toLowerCase().startsWith(code.toLowerCase())) {
                bookings.add(flight);
                System.out.println("Flight booked: " + flight);
                exists = true;
                break;
            }
        }
        if (!exists) {
            System.out.println("Flight code not found.");
        }
    }

    public static void displayBookings() {
        System.out.println("\nYour Bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (String b : bookings) {
                System.out.println(b);
            }
        }
    }
}