package hus.oop.test_exam_training_2022.decorator;

public abstract class ToppingDecorator extends Bread {
    Bread bread;

    public abstract String getDescription();
}
