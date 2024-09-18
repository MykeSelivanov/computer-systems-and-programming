package oop.creationaldesignpatterns.factory;

public class PdfDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening a PDF document");
    }
}
