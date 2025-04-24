package hus.oop.lab10.strategy.an_example_of_strategy_pattern;

public class TestStrategyGreeting {
    public static void main(String[] args) {

        // Initial strategy for vietnamese and english
        Context strategy = new Context();
        GreetingStrategy vietnamese = new VietnameseGreeting();
        GreetingStrategy english = new EnglishGreeting();

        strategy.setStrategy(vietnamese);
        strategy.greet();
        // Say Hello in vietnamese and english

        strategy.setStrategy(english);
        strategy.greet();
    }
}
