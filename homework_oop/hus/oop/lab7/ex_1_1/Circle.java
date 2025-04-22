package hus.oop.lab7.ex_1_1;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(double radius) {
        super();
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

    @Override
    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() +
                ", radius=" + radius +
                '}';
    }
}
