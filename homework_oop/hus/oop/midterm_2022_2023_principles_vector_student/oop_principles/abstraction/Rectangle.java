package hus.oop.midterm_2022_2023_principles_vector_student.oop_principles.abstraction;

class Rectangle implements Shape {
    private double w, h;

    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public double area() {
        return w * h;
    }
}
