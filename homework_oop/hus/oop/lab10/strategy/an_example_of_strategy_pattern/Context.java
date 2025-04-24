package hus.oop.lab10.strategy.an_example_of_strategy_pattern;

public class Context {
    private GreetingStrategy strategy;

    public void setStrategy(GreetingStrategy strategy) {
        this.strategy = strategy;
    }

    public void greet() {
        if (strategy != null) {
            strategy.greet();
        } else {
            System.out.println("No greeting strategy set.");
        }
    }
}
