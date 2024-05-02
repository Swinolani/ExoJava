package org.example.Entity;

public class Smartphone extends Product{
    private String processor,memory;

    public Smartphone(SmartphoneBuilder builder) {
        this.processor = builder.processor;
        this.memory = builder.memory;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }

    public static class SmartphoneBuilder extends AbstractProductBuilder{
        private String processor,memory;
        public SmartphoneBuilder processor(String processor){
            this.processor=processor;
            return this;
        }
        public SmartphoneBuilder memory(String memory){
            this.memory=memory;
            return this;
        }
        @Override
        public Product build() {
            return new Smartphone(this);
        }
    }
}
