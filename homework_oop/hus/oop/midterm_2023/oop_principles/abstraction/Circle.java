package hus.oop.midterm_2023.oop_principles.abstraction;

// lớp con hiện thực chi tiết

class Circle implements Shape {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
