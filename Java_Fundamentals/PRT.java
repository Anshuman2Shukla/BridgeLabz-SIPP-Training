import java.util.Scanner;

public class PRT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Principal value: ");
        double principal = sc.nextDouble();
        System.out.println("Enter the Rate value: ");
        double rate = sc.nextDouble();
        System.out.println("Enter the Time value: ");
        double time = sc.nextDouble();
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal
                + ", Rate of Interest " + rate + " and Time " + time);
        sc.close();
    }
}