package hus.oop.lab11.visitor_pattern.shape;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {
    List<Shape> shapes = new ArrayList<>();

    public CompoundShape(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void move(double x, double y) {
        for (Shape shape : shapes) {
            shape.move(x, y);
        }
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitCompoundShape(this);
    }

    @Override
    public String toString() {
        return "CompoundShape{" +
                "shapes=" + shapes +
                '}';
    }
}
