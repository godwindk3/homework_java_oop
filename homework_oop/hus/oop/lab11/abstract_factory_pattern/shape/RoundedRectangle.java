package hus.oop.lab11.abstract_factory_pattern.shape;

public class RoundedRectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Round Rectangle");
    }
}
