package hus.oop.lab4.ex_2_10;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(int x, int y) {
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

    public int[] getXY() {
        int[] XY = {this.x, this.y};

        return XY;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String xyFormat = String.format("(%d,%d)", this.x, this.y);
        return xyFormat;
    }

    public double distance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double distance(MyPoint another) {
        return Math.sqrt((this.x - another.getX()) * (this.x - another.getX()) + (this.y - another.getY()) * (this.y - another.getY()));
    }
}
