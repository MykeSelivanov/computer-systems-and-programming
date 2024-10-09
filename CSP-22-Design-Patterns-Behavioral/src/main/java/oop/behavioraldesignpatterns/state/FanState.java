package oop.behavioraldesignpatterns.state;

public interface FanState {
    void handleRequest(Fan fan);
    void undoRequest(Fan fan);
}
