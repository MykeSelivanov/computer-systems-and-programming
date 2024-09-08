package oop.ooppractice.cloning;

public class Human implements Cloneable {
    int age;
    String name;
    int[] arr = new int[]{1, 2, 3, 4, 5};

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // copy constructor
//    public Human(Human otherHuman) {
//        this.age = otherHuman.age;
//        this.name = otherHuman.name;
//        this.arr = otherHuman.arr;
//    }

    // shallow copy
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    // deep copy
    public Object clone() throws CloneNotSupportedException {
        Human clone = (Human) super.clone(); // this is still a shallow copy

        clone.arr = new int[clone.arr.length];
        for (int i = 0; i < arr.length; i++) {
            clone.arr[i] = this.arr[i];
        }
        return clone;
    }
}
