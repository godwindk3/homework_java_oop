package hus.oop.lab11.visitor_pattern.shape;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Shape dot = new Dot();
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(dot);
        shapes.add(circle);
        shapes.add(rectangle);

        Shape compoundShape = new CompoundShape(shapes);
        Visitor visitor = new XMLExportVisitor();

        circle.accept(visitor);
        rectangle.accept(visitor);
        dot.accept(visitor);

        compoundShape.accept(visitor);


    }
}
