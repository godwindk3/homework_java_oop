package hus.oop.lab10.strategy.demonstrate_pseudocode;

public class Context {

    private static Context instance;
    private Strategy strategy;

    private Context() {
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}
