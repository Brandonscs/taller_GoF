package co.edu.taller.structural.facade;

public class CheckoutFacade {
    public interface Inventory {
        boolean reserve(String sku, int quantity);
    }

    public interface Payment {
        boolean charge(String orderId, long amount);
    }

    private final Inventory inventory;
    private final Payment payment;

    public CheckoutFacade(Inventory i, Payment p) {
        this.inventory = i != null ? i : (sku, qty) -> false;
        this.payment = p != null ? p : (id, amt) -> false;
    }

    public String checkout(String orderId, String sku, int quantity, long amount) {
        boolean inventoryReserved = inventory.reserve(sku, quantity);
        if (!inventoryReserved) {
            throw new IllegalStateException("Inventory unavailable for SKU: " + sku);
        }

        boolean paymentCharged = payment.charge(orderId, amount);
        if (!paymentCharged) {
            throw new IllegalStateException("Payment declined for order: " + orderId);
        }

        return "CONFIRMED:" + orderId;
    }
}