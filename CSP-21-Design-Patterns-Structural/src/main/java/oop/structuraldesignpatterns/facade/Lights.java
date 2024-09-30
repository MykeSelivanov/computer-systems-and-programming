package oop.structuraldesignpatterns.facade;

public class Lights {
    public void dim(int level) {
        System.out.println("Lights are dimmed to " + level + "%");
    }

    public void on() {
        System.out.println("Lights are on");
    }

    public void off() {
        System.out.println("Lights are off");
    }
}
