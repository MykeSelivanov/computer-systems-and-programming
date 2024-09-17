package oop.creationaldesignpatterns.factory;

public class DocDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening a DOC document");
    }
}
