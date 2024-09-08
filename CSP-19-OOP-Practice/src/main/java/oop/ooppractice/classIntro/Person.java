package oop.ooppractice.classIntro;

public class Person {
    private String name;
    private int age;

    // parametrized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // copy constuctor
    public Person(Person anotherPerson) {
        this.name = anotherPerson.name;
        this.age = anotherPerson.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
