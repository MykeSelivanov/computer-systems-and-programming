package oop.behavioraldesignpatterns.state;

public class Fan {
    private FanState currentState;

    public Fan() {
        this.currentState = new OffState();
    }

    public void setState(FanState state) {
        this.currentState = state;
    }

    public void request(){
        currentState.handleRequest(this);
    }

    public void cancel() {
        currentState.undoRequest(this);
    }
}
