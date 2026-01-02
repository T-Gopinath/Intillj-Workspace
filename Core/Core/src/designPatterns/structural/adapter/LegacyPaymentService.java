package designPatterns.structural.adapter;

public class LegacyPaymentService {
    public void makePayment(double amount) {
        System.out.println("Payment made using legacy service: " + amount);
    }
}
