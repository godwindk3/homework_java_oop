package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.decorator;

public abstract class Bread {
    String description = "Bread";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
