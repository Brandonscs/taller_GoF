package co.edu.taller.structural.decorator;

public interface ShippingCost {
    long cost();

    class Standard implements ShippingCost {
        @Override
        public long cost() {
            return 12000L;
        }
    }

    abstract class Decorator implements ShippingCost {
        protected final ShippingCost innerCost;

        public Decorator(ShippingCost innerCost) {
            if (innerCost == null) {
                throw new IllegalArgumentException("Inner shipping cost cannot be null");
            }
            this.innerCost = innerCost;
        }
    }

    class Insurance extends Decorator {
        public Insurance(ShippingCost innerCost) {
            super(innerCost);
        }

        @Override
        public long cost() {
            return innerCost.cost() + 5000L;
        }
    }

    class Priority extends Decorator {
        public Priority(ShippingCost innerCost) {
            super(innerCost);
        }

        @Override
        public long cost() {
            return innerCost.cost() + 4500L;
        }
    }
}