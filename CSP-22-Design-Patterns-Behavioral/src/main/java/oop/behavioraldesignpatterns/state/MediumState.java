package oop.behavioraldesignpatterns.state;

public class MediumState implements FanState{
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on high");
        fan.setState(new HighState());
    }

    @Override
    public void undoRequest(Fan fan) {
        System.out.println("Fan turned on low");
        fan.setState(new LowState());
    }
}
