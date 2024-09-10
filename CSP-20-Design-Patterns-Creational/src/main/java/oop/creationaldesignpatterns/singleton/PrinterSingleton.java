package oop.creationaldesignpatterns.singleton;

public class PrinterSingleton {
    private static PrinterSingleton instance;

    private PrinterSingleton() {
        // private constructor to prevent direct instantiation
    }

    public static PrinterSingleton getInstance() {
        if (instance == null) {
            instance = new PrinterSingleton();
        }
        return instance;
    }

    public void printDocument(String document) {
        // implementation to print the document
        System.out.println("Printing: " + document);
    }
}
