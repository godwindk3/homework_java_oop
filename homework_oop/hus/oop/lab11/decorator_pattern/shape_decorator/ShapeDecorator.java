package hus.oop.lab11.decorator_pattern.shape_decorator;

public abstract class ShapeDecorator implements Shape{

    public Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
