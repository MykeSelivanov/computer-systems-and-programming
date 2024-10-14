package oop.behavioraldesignpatterns.template;

public class Main {
    public static void main(String[] args) {
        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.makeBeverage();

        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
    }
}
