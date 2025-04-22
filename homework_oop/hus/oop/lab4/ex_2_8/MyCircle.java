package hus.oop.lab4.ex_2_8;

public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle() {
        this.center = new MyPoint(0, 0);
        this.radius = 1;
    }

    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x, y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return this.center.getX();
    }

    public void setCenterX(int x) {
        this.center.setX(x);
    }

    public int getCenterY() {
        return this.center.getY();
    }

    public void setCenterY(int y) {
        this.center.setY(y);
    }

    public int[] getCenterXY() {
        int[] XY = new int[2];
        XY[0] = this.getCenterX();
        XY[1] = this.getCenterY();
        return XY;
    }

    public void setCenterXY(int x, int y) {
        this.setCenterX(x);
        this.setCenterY(y);
    }

    @Override
    public String toString() {
        return "MyCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    public double getCircumference() {
        return 2 * Math.PI * this.getRadius();
    }

    public double distance(MyCircle another) {
        return this.center.distance(another.getCenter());
    }
}
