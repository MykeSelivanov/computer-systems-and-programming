package oop.structuraldesignpatterns.composite;

public class Leaf implements Component{
    String name;
    Double price;

    public Leaf() {}

    public Leaf(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println(this.price);
    }
}
