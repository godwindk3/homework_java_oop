package hus.oop.homework5.ex_1_6;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;

        this.radius = radius;

        this.xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
        this.yDelta = (float) (speed * Math.sin(Math.toRadians(direction)));

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        this.setX(this.getX() + this.getXDelta());
        this.setY(this.getY() + this.getYDelta());
    }

    public void reflectHorizontal() {
        this.setXDelta(-this.getXDelta());
    }

    public void reflectVertical() {
        this.setYDelta(-this.getYDelta());
    }

    public String toString() {
        return "Ball[(" + this.getX() + "," + this.getY() + "),speed=(" + this.getXDelta() + "," + this.getYDelta() + ")]";
    }
}
