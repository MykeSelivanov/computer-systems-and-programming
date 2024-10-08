package oop.behavioraldesignpatterns.command;

public class Main {
    public static void main(String[] args) {
        RestaurantCommandExecutor executor = new RestaurantCommandExecutor();

        executor.executeOperation(new OrderFoodCommand());
        executor.executeOperation(new PayCommand());
    }
}
