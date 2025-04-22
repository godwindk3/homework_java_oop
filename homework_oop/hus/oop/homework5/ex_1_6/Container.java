package hus.oop.homework5.ex_1_6;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width - 1;
        this.y2 = y + height - 1;
    }

    public int getX() {
        return this.x1;
    }

    public int getY() {
        return this.y1;
    }

    public int getWidth() {
        return this.x2 - this.x1 + 1;
    }

    public int getHeight() {
        return this.y2 - this.y1 + 1;
    }

    public boolean collidesWith(Ball ball) {
        boolean collided = false;

        if (ball.getX() - ball.getRadius() < this.x1 || ball.getX() + ball.getRadius() > this.x2) {
            ball.reflectHorizontal();
            collided = true;
        }

        if (ball.getY() - ball.getRadius() < this.y1 || ball.getY() + ball.getRadius() > this.y2) {
            ball.reflectVertical();
            collided = true;
        }

        return collided;

    }
}
