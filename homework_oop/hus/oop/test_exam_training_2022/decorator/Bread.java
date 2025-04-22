package hus.oop.test_exam_training_2022.decorator;

public abstract class Bread {
    String description = "Bread";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
