package oop.behavioraldesignpatterns.state;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.request(); // turns on low
        fan.request(); // turns on medium
        fan.request(); // turns on high
        fan.cancel(); // turns on medium
        fan.request(); // turns on high
    }
}
