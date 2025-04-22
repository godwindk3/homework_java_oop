package hus.oop.homework5.ex_1_6;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(0.0f, 0.0f, 10, 5, 45);
        System.out.println("Initial state: " + ball);

        ball.move();
        System.out.println("After moving: " + ball);

        ball.reflectHorizontal();
        System.out.println("After horizontal reflection: " + ball);

        ball.move();
        System.out.println("Move after horizontal reflection: " + ball);

        ball.reflectVertical();
        System.out.println("After vertical reflection: " + ball);

        ball.setRadius(20);
        ball.setX(10.0f);
        ball.setY(10.0f);
        System.out.println("After changing radius and position: " + ball);

    }
}
