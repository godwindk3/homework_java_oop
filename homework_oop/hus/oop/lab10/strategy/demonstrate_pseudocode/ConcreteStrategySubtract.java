package hus.oop.lab10.strategy.demonstrate_pseudocode;

public class ConcreteStrategySubtract implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
