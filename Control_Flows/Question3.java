import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0, input;

        System.out.println("Enter numbers to sum (0 to stop):");
        while ((input = sc.nextDouble()) != 0) {
            total += input;
        }

        System.out.println("Total sum: " + total);
    }
}