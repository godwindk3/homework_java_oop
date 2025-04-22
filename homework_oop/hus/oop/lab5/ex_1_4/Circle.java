package hus.oop.lab5.ex_1_4;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() +
                "radius=" + radius +
                '}';
    }
}
