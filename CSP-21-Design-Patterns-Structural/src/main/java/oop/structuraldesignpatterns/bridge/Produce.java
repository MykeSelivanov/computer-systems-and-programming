package oop.structuraldesignpatterns.bridge;

// concrete implementation 1 for bridge pattern
public class Produce implements Workshop {
    @Override
    public void work() {
        System.out.println("Produced");
    }
}
