package hus.oop.lab11.visitor_pattern.shape;

public interface Shape {
    void move(double x, double y);

    void draw();

    void accept(Visitor v);
}
