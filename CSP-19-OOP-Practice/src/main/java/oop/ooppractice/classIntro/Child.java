package oop.ooppractice.classIntro;

public class Child extends Person{
    Person parent;

    public Child(String name, int age, Person parent) {
        super(name, age);
        this.parent = parent;
    }

    public Child(Child anotherChild) {
        super(anotherChild);
        this.parent = anotherChild.parent;
    }

    public void printParent() {
        System.out.println(parent.getName());
    }
}
