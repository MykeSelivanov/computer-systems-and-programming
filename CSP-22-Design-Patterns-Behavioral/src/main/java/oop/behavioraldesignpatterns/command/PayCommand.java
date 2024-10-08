package oop.behavioraldesignpatterns.command;

public class PayCommand implements RestaurantCommand{
    private Phone phone;

    public PayCommand() {
    }

    @Override
    public String execute() {
        return phone.pay();
    }
}
