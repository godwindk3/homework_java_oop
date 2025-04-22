package hus.oop.lab5.ex_2_1;

public class LineSub extends Point {
    Point end;

    public LineSub(int beginX, int beginY, int endX, int endY) {
        super(beginX, beginY);
        this.end = new Point(endX, endY);
    }

    public LineSub(Point begin, Point end) {
        super(begin.getX(), begin.getY());
        this.end = end;
    }

    @Override
    public String toString() {
        return "LineSub{" + "begin=" + super.toString() +
                "end=" + end +
                '}';
    }

    public Point getBegin() {
        return new Point(super.getX(), super.getY());
    }

    public Point getEnd() {
        return this.end;
    }

    public void setBegin(int x, int y) {
        super.setX(x);
        super.setY(y);
    }

    public void setEnd(int x, int y) {
        this.end.setX(x);
        this.end.setY(y);
    }

    public int getBeginX() {
        return super.getX();
    }

    public void setBeginX(int x) {
        super.setX(x);
    }

    public int getBeginY() {
        return super.getY();
    }

    public void setBeginY(int y) {
        super.setY(y);
    }

    public int getEndX() {
        return this.end.getX();
    }

    public void setEndX(int x) {
        this.end.setX(x);
    }

    public int getEndY() {
        return this.end.getY();
    }

    public void setEndY(int y) {
        this.end.setY(y);

    }

    public void setBeginXY(int x, int y) {
        this.setBeginX(x);
        this.setBeginY(y);
    }

    public void setEndXY(int x, int y) {
        this.setEndX(x);
        this.setEndY(y);
    }

    public double getLength() {
        int xDiff = super.getX() - this.end.getX();
        int yDiff = super.getY() - this.end.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double getGradient() {
        int xDiff = this.end.getX() - super.getX(); // end.x - begin.x
        int yDiff = this.end.getY() - super.getY(); // end.y - begin.y
        return Math.atan2(yDiff, xDiff);
    }
}
