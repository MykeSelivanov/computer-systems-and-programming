package oop.structuraldesignpatterns.bridge;

public class Car extends Vehicle{
    protected Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Car");
        workshop1.work();
        workshop2.work();
    }
}
