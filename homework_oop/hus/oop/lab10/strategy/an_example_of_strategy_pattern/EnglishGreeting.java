package hus.oop.lab10.strategy.an_example_of_strategy_pattern;

public class EnglishGreeting implements GreetingStrategy {

    @Override
    public void greet() {
        System.out.println("Hello!");
    }
}
