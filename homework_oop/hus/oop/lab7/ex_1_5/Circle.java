package hus.oop.lab7.ex_1_5;

public class Circle implements GeometricObject {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }


}
