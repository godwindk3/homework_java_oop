package hus.oop.lab7.ex_1_2;

public class Circle implements GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2.0 * Math.PI * this.radius;
    }
}
