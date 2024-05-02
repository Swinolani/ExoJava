package org.example.Entity;

public class Bike extends Product {
    private String typeWheels;

    public Bike(BikeBuilder build) {
        this.typeWheels = build.typeWheels;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "typeWheels='" + typeWheels + '\'' +
                '}';
    }

    public static class BikeBuilder extends AbstractProductBuilder{
        private String typeWheels;

        public BikeBuilder typeWheels(String typeWheels){
            this.typeWheels=typeWheels;
            return this;
        }

        @Override
        public Product build() {
            return new Bike(this);
        }
    }
}
