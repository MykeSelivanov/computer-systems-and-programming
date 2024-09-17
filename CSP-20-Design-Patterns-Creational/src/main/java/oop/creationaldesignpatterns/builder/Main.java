package oop.creationaldesignpatterns.builder;

public class Main {
    public static void main(String[] args) {
        House moderHouse = new House.Builder()
                .buildFoundation(new Foundation())
                .buildWalls(new Walls())
                .buildRoof(new Roof())
                .build();
    }
}
