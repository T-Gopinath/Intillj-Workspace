package designPatterns.behavioural.strategy;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Credit Card payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012"));
        context.payAmount(500);

        // UPI payment
        context.setPaymentStrategy(new UPIPayment("gopi@upi"));
        context.payAmount(300);

        // PayPal payment
        context.setPaymentStrategy(new PayPalPayment("gopi@gmail.com"));
        context.payAmount(1000);
    }
}
/**
 * 🔹 Real-World Use Cases
 *
 * Payment methods
 *
 * Sorting algorithms
 *
 * Compression (ZIP, RAR, 7z)
 *
 * Authentication mechanisms
 */