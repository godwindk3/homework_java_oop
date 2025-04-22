package hus.oop.lab5.ex_1_4;

public class TestMain {
    public static void main(String[] args) {
        Shape shape = new Shape("blue", false);
        System.out.println("Shape: " + shape);

        // Test Circle
        Circle circle = new Circle("green", true, 2.0);
        System.out.println("Circle: " + circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // Test Rectangle
        Rectangle rectangle = new Rectangle("yellow", false, 3.0, 4.0);
        System.out.println("Rectangle: " + rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Test Square
        Square square = new Square(5.0, "red", true);
        System.out.println("Square: " + square);
        System.out.println("Area: " + square.getArea());
        square.setSide(6.0);
        System.out.println("After setSide: " + square);
    }
}
