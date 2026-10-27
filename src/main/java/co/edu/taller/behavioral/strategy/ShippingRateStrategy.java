package co.edu.taller.behavioral.strategy;

public class ShippingRateStrategy {

    public interface Rate {
        long calculate(long base);
    }

    public enum Mode { STANDARD, EXPRESS, NIGHT }

    public long quote(Mode mode, long base) {
        // Validar que la base sea mayor a 0 (si es <= 0, lanza IllegalArgumentException)
        if (base <= 0) {
            throw new IllegalArgumentException("Base rate must be greater than zero");
        }
        if (mode == null) {
            throw new IllegalArgumentException("Mode cannot be null");
        }

        // Seleccionar la estrategia adecuada según el modo (Patrón Strategy)
        Rate strategy;
        switch (mode) {
            case STANDARD:
                strategy = new StandardRate();
                break;
            case EXPRESS:
                strategy = new ExpressRate();
                break;
            case NIGHT:
                strategy = new NightRate();
                break;
            default:
                throw new IllegalArgumentException("Unsupported shipping mode: " + mode);
        }

        // Delegar el cálculo a la estrategia seleccionada
        return strategy.calculate(base);
    }

    // --- Estrategias Concretas ---

    public static class StandardRate implements Rate {
        @Override
        public long calculate(long base) {
            return base; // Tarifa estándar (1x)
        }
    }

    public static class ExpressRate implements Rate {
        @Override
        public long calculate(long base) {
            return (long) (base * 1.8);
        }
    }

    public static class NightRate implements Rate {
        @Override
        public long calculate(long base) {
            return base * 2;
        }
    }
}