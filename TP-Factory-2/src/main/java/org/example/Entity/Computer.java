package org.example.Entity;

public class Computer extends Product{
    private String processor,memory;

    public Computer(ComputerBuilder builder) {
        this.processor = builder.processor;
        this.memory = builder.memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }

    public static class ComputerBuilder extends AbstractProductBuilder{
        private String processor,memory;

        public ComputerBuilder processor(String processor){
            this.processor=processor;
            return this;
        }
        public ComputerBuilder memory(String memory){
            this.memory=memory;
            return this;
        }
        @Override
        public Product build() {
            return new Computer(this);
        }
    }
}
