package hus.oop.lab7.ex_1_8;

public class TestMovableRectangle {
    public static void main(String[] args) {

        MovableRectangle rectangle = new MovableRectangle(0, 4, 4, 0, 2, 3);

        System.out.println("Initial state: " + rectangle);

        rectangle.moveRight();
        System.out.println("After moving right: " + rectangle);

        rectangle.moveUp();
        System.out.println("After moving up: " + rectangle);

        rectangle.moveLeft();
        System.out.println("After moving left: " + rectangle);

        rectangle.moveDown();
        System.out.println("After moving down: " + rectangle);
    }
}
