package oop.behavioraldesignpatterns.state;

public class HighState implements FanState{
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned off");
        fan.setState(new OffState());
    }

    @Override
    public void undoRequest(Fan fan) {
        System.out.println("Fan turned on medium");
        fan.setState(new MediumState());
    }
}