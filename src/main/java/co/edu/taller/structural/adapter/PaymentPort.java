package co.edu.taller.structural.adapter;

public interface PaymentPort {
    String charge(String orderId, long pesos);
}
