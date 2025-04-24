package hus.oop.lab10.singleton.an_example_of_singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Hello world!");
        logger2.log("Logging again...");

        System.out.println(logger1 == logger2);
    }
}
