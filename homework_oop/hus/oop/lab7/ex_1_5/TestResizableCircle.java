package hus.oop.lab7.ex_1_5;

public class TestResizableCircle {
    public static void main(String[] args) {

        ResizableCircle resizableCircle = new ResizableCircle(5.0);

        System.out.println("Initial state: " + resizableCircle);
        System.out.println("Initial Area: " + resizableCircle.getArea());
        System.out.println("Initial Perimeter: " + resizableCircle.getPerimeter());


        resizableCircle.resize(150);
        System.out.println("\nAfter resizing 150%: " + resizableCircle);
        System.out.println("New Area: " + resizableCircle.getArea());
        System.out.println("New Perimeter: " + resizableCircle.getPerimeter());


        resizableCircle.resize(50);
        System.out.println("\nAfter resizing 50%: " + resizableCircle);
        System.out.println("New Area: " + resizableCircle.getArea());
        System.out.println("New Perimeter: " + resizableCircle.getPerimeter());
    }
}
