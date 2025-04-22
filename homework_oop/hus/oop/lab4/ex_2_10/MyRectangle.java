package hus.oop.lab4.ex_2_10;

public class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;

    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public MyPoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = topLeft;
    }

    public MyPoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    public int getHeight() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }

    public int getArea() {
        return this.getHeight() * this.getWidth();
    }

    public int getPerimeter() {
        return 2 * (this.getWidth() + this.getHeight());
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }
}
