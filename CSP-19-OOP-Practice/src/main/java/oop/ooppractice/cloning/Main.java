package oop.ooppractice.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human aliya = new Human(28, "Aliya");
//        Human aliyaClone = new Human(aliya);
        Human aliyaClone = (Human) aliya.clone();

        System.out.println(aliyaClone.age + " " + aliyaClone.name);
        System.out.println(Arrays.toString(aliyaClone.arr));

        aliyaClone.arr[0] = 50;
        System.out.println(Arrays.toString(aliyaClone.arr));

        System.out.println(Arrays.toString(aliya.arr));
    }
}
