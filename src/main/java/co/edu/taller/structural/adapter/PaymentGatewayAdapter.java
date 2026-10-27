package co.edu.taller.structural.adapter;

public class PaymentGatewayAdapter implements PaymentPort {

    public static class LegacyGateway {
        public String chargeInCents(String id, long cents) {
            return "LEGACY:" + id + ":" + cents;
        }
    }

    private final LegacyGateway legacy;

    public PaymentGatewayAdapter(LegacyGateway legacy) {
        this.legacy = legacy != null ? legacy : new LegacyGateway();
    }

    @Override
    public String charge(String orderId, long pesos) {

        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be blank or null");
        }

        if (pesos <= 0) {
            throw new IllegalArgumentException("Amount in pesos must be greater than zero");
        }

        long cents = pesos * 100;

        return legacy.chargeInCents(orderId, cents);
    }
}