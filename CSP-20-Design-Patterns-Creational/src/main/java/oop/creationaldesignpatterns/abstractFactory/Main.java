package oop.creationaldesignpatterns.abstractFactory;

public class Main {
    public static Application createApp() {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        Application app = new Application(factory);
        return app;
    }
}
