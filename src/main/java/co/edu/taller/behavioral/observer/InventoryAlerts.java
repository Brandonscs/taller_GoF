package co.edu.taller.behavioral.observer;

import java.util.*;

public class InventoryAlerts {
    public interface Listener {
        void onLowStock(String sku, int quantity);
    }

    private final int threshold;
    private final List<Listener> listeners = new ArrayList<>();

    public InventoryAlerts(int threshold) {
        this.threshold = threshold;
    }

    public void subscribe(Listener listener) {
        // Validar que el listener no sea nulo, lanzando IllegalArgumentException
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.add(listener);
    }

    public void update(String sku, int quantity) {
        // Verificar si la cantidad llegó o cayó por debajo del umbral configurado
        if (quantity <= threshold) {
            // Notificar a todos los observadores registrados
            for (Listener listener : listeners) {
                listener.onLowStock(sku, quantity);
            }
        }
    }
}