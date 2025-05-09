package hus.oop.lab11.visitor_pattern.shape;

public class Dot implements Shape {
    public double x;
    public double y;

    public Dot() {
        this.x = 0;
        this.y = 0;
    }

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Dot{" +
                "x=" + x +
                ", y=" + y +
                '}');
    }

    @Override
    public void accept(Visitor v) {
        v.visitDot(this);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
