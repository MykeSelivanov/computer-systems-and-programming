package oop.structuraldesignpatterns.adapter;

public class Main {
    // using the adapter
    public static void main(String[] args) {
        Printer printer = new PrinterAdapter();
        printer.print();
    }
}
