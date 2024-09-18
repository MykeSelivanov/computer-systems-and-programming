package oop.creationaldesignpatterns.factory;

public class DocFactory implements DocumentFactory{
    @Override
    public Document createDocument() {
        return new DocDocument();
    }
}
