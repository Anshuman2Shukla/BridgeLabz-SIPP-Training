
interface PaymentMethod {
    void pay(double amount);
}

class UPI implements PaymentMethod {
    public void pay(double amount) { System.out.println("Paid " + amount + " via UPI"); }
}

class CreditCard implements PaymentMethod {
    public void pay(double amount) { System.out.println("Paid " + amount + " via Credit Card"); }
}

class Wallet implements PaymentMethod {
    public void pay(double amount) { System.out.println("Paid " + amount + " via Wallet"); }
}

public class Problem03_DigitalPayment {
    public static void main(String[] args) {
        PaymentMethod pm = new CreditCard();
        pm.pay(500.0);
    }
}
