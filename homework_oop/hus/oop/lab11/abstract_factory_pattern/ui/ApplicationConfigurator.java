package hus.oop.lab11.abstract_factory_pattern.ui;

public class ApplicationConfigurator {
    public static void main(String[] args) {

        Config config = readApplicationConfigFile();

        GUIFactory factory;

        if (config.OS.equalsIgnoreCase("Windows")) {
            factory = new WinFactory();
        } else if (config.OS.equalsIgnoreCase("Mac")) {
            factory = new MacFactory();
        } else {
            throw new RuntimeException("Error! Unknown OS");
        }
        Application application = new Application(factory);
        application.createUI();
        application.paint();

    }

    public static Config readApplicationConfigFile() {
        return new Config("Windows");
    }
}
