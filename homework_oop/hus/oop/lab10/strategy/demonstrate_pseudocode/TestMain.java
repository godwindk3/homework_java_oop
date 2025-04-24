package hus.oop.lab10.strategy.demonstrate_pseudocode;

public class TestMain {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;

        Strategy addStrategy = new ConcreteStrategyAdd();
        Strategy subtractStrategy = new ConcreteStrategySubtract();
        Strategy multiplyStrategy = new ConcreteStrategyMultiply();

        Context context = Context.getInstance();

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        context.setStrategy(addStrategy);
        System.out.println("Add: " + context.executeStrategy(a, b));

        context.setStrategy(subtractStrategy);
        System.out.println("Subtract: " + context.executeStrategy(a, b));

        context.setStrategy(multiplyStrategy);
        System.out.println("Multiply: " + context.executeStrategy(a, b));

    }
}
