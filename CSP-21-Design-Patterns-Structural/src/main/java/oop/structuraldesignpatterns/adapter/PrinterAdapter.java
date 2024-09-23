package oop.structuraldesignpatterns.adapter;

public class PrinterAdapter implements Printer{
    private final LegacyPrinter legacyPrinter;

    public PrinterAdapter() {
        legacyPrinter = new LegacyPrinter();
    }

    @Override
    public void print() {
        legacyPrinter.setFormat("utf-8");
        legacyPrinter.printDocument();
    }
}
