package oop.filehandling1.serializationdeserialization;

import java.io.Serializable;

public class Employee implements Serializable {
    String name;
    transient int age; // salary will not be serialized

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
