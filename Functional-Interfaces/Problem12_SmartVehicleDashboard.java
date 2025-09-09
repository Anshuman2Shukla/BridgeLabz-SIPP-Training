
interface VehicleDashboard {
    void displaySpeed();
    default void displayBattery() {
        System.out.println("Battery info not available.");
    }
}

class PetrolCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 80 km/h"); }
}

class ElectricCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 100 km/h"); }
    public void displayBattery() { System.out.println("Battery: 75%"); }
}

public class Problem12_SmartVehicleDashboard {
    public static void main(String[] args) {
        VehicleDashboard ev = new ElectricCar();
        ev.displaySpeed();
        ev.displayBattery();
        VehicleDashboard pv = new PetrolCar();
        pv.displayBattery();
    }
}
