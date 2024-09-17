package oop.creationaldesignpatterns.prototype;

public class Circle implements Shape{
    private int x,y;
    private int radius;
    private String color;

    // constructor, getters, setters

    @Override
    public Shape clone() {
        Circle clone = new Circle();
        clone.x = this.x;
        clone.y = this.y;
        clone.radius = this.radius;
        clone.color = this.color;
        return clone;
    }

    @Override
    public void draw() {
    }
}
