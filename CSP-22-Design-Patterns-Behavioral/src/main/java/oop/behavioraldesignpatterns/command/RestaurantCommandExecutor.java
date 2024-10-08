package oop.behavioraldesignpatterns.command;

public class RestaurantCommandExecutor {
    public String executeOperation(RestaurantCommand restaurantCommand) {
        return restaurantCommand.execute();
    }
}
