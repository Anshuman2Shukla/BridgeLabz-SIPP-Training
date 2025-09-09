
interface PaymentProcessor {
    void processPayment(double amount);
    default void refund(double amount) {
        System.out.println("Refunding " + amount + " by default logic.");
    }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("PayPal processed " + amount); }
}

public class Problem10_PaymentGateway {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPal();
        pp.processPayment(200);
        pp.refund(50);
    }
}
