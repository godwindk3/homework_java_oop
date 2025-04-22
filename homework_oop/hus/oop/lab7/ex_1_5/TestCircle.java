package hus.oop.lab7.ex_1_5;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);

        System.out.println("Circle Info: " + circle);
        System.out.println("Initial Area: " + circle.getArea());
        System.out.println("Initial Perimeter: " + circle.getPerimeter());
    }

}
