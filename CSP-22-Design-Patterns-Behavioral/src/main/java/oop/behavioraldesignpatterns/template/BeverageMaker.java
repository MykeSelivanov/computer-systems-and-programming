package oop.behavioraldesignpatterns.template;

// Abstract class defining the template method
abstract class BeverageMaker {
    // template method defining the overall process
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Abstract method to be implemented by subclasses
    abstract void brew();
    abstract void addCondiments();

    // Common methods
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pour into cup");
    }
}
