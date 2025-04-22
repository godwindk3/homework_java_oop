package hus.oop.lab5.ex_2_2;

public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder() {
        this.base = new Circle();
        this.height = 1.0;
    }

    public Cylinder(double radius) {
        this.base = new Circle(radius);
        this.height = 1.0;
    }

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        this.base = new Circle(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }

    public double getVolume() {
        return this.getHeight() * this.base.getArea();
    }
}
