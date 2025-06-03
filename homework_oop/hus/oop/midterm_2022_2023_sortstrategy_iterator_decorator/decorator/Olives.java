package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.decorator;

public class Olives extends ToppingDecorator {
    public Olives(Bread bread) {
        this.bread = bread;
    }

    public String getDescription() {
        return bread.getDescription() + ", Olives";
    }

    public double cost() {
        return bread.cost() + 2.0;
    }
}