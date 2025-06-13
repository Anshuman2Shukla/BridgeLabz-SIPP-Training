import java.util.*;
public class Miles{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double distance_in_km=input.nextDouble();
        double distance_in_miles=distance_in_km*1.6;
        System.out.print("The total miles is"+" "+distance_in_miles+" "+"mile for the given"+" "+distance_in_km+" "+"km");
    }
}