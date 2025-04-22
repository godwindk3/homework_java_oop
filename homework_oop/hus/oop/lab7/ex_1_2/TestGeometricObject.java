package hus.oop.lab7.ex_1_2;

public class TestGeometricObject {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Circle Info: " + circle);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());

        System.out.println();

        // Test Rectangle
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Rectangle Info: " + rectangle);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
    }
}
