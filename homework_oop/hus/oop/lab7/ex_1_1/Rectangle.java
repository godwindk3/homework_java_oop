package hus.oop.lab7.ex_1_1;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return this.getWidth() * this.getLength();
    }

    @Override
    public double getPerimeter() {
        return 2.0 * (this.getLength() + this.getWidth());
    }

    @Override
    public String toString() {
        return "Rectangle{" + super.toString() +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
