import java.util.Scanner;

public class Height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your height in centimeters: ");
        double heightInCm = sc.nextDouble();
        double heightInInches = (heightInCm / 2.54);
        double heightInFeet = (heightInInches / 12);
        System.out.println(
                "Your Height in cm is " + heightInCm + " while in feet is " + String.format("%.3f", heightInFeet)
                        + " and inches is " + String.format("%.3f", heightInInches));
        sc.close();
    }
}
