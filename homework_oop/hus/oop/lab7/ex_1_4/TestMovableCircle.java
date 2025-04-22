package hus.oop.lab7.ex_1_4;

public class TestMovableCircle {
    public static void main(String[] args) {

        MovableCircle circle = new MovableCircle(0, 0, 2, 3, 5);


        System.out.println("Initial state: " + circle);


        circle.moveRight();
        System.out.println("After moving right: " + circle);

        circle.moveUp();
        System.out.println("After moving up: " + circle);

        circle.moveLeft();
        System.out.println("After moving left: " + circle);

        circle.moveDown();
        System.out.println("After moving down: " + circle);
    }
}
