package oop.structuraldesignpatterns.decorator;

public class ChristmasTreeImpl implements ChristmasTree{

    public ChristmasTreeImpl() {
    }

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}
