package oop.behavioraldesignpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class OrderFoodCommand implements RestaurantCommand{
    public OrderFoodCommand() {
    }

    private String order(List<String> dishes) {
        return dishes.toString();
    }

    @Override
    public String execute() {
        return order(new ArrayList<String>() {});
    }
}
