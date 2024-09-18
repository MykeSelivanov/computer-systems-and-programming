package oop.creationaldesignpatterns.abstractFactory;

/**
 * Each concrete factory extends basic factory and is responsible
 * for creating products of a single variety
 */
public class MacOSFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
