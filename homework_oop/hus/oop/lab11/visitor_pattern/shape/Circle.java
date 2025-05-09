package hus.oop.lab11.visitor_pattern.shape;

public class Circle implements Shape {
    public Dot center;
    public double radius;

    public Circle() {
        this.center = new Dot();
        this.radius = 1.0;
    }

    public Circle(Dot center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void move(double x, double y) {
        this.center.setX(this.center.getX() + x);
    }

    @Override
    public void draw() {
        System.out.println("Circle{" +
                "center=" + center.toString() +
                ", radius=" + radius +
                '}');
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void accept(Visitor v) {
        v.visitCircle(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center.toString() +
                ", radius=" + radius +
                '}';
    }
}
