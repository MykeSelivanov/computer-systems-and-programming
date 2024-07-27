package oop.basics.shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(3, 4, 5);
        Shape square = new Square(4);

        System.out.println("Circle: Area = " + circle.calculateArea() + ", Perimeter = " + circle.calculatePerimeter());
        System.out.println("Triangle: Area = " + triangle.calculateArea() + ", Perimeter = " + triangle.calculatePerimeter());
        System.out.println("Square: Area = " + square.calculateArea() + ", Perimeter = " + square.calculatePerimeter());
    }
}
