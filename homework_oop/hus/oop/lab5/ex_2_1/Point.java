package hus.oop.lab5.ex_2_1;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "Point: (" + this.getX() + "," + this.getY() + ")";
    }
    public void setXY(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
