package hus.oop.lab10.singleton.an_example_of_singleton_pattern;

public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger created");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
