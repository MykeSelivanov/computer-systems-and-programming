package oop.ooppractice.classIntro;

public class Main {
    public static void main(String[] args) {
        Person myke = new Person("Myke", 45);
        Person copy = new Person(myke);
        copy.setName("Test");

        System.out.println("Copy object name is " + copy.getName());

        Child myChild = new Child("Baby", 2, new Person("NewParent", 30));
        myChild.printParent();


        BalanceImpl balance = new BalanceImpl(25);
        System.out.println(balance.getCurrentBalance());

        balance.setCurrentBalance(50);
        System.out.println(balance.getCurrentBalance());
    }
}
