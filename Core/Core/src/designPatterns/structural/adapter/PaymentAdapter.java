package designPatterns.structural.adapter;

public class PaymentAdapter implements PaymentProcessor {

    private LegacyPaymentService legacyService;

    public PaymentAdapter(LegacyPaymentService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public void pay(int amount) {
        legacyService.makePayment(amount);
    }
}
