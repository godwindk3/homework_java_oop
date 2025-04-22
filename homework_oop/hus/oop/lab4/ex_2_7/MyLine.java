package hus.oop.lab4.ex_2_7;


public class MyLine {
    private MyPoint begin;
    private MyPoint end;

    public MyLine(MyPoint begin, MyPoint end) {
        this.begin = begin;
        this.end = end;
    }

    public MyLine(int x1, int y1, int x2, int y2) {
        MyPoint begin = new MyPoint(x1, y1);
        MyPoint end = new MyPoint(x2, y2);

        this.begin = begin;
        this.end = end;
    }

    public MyPoint getBegin() {
        return begin;
    }

    public void setBegin(MyPoint begin) {
        this.begin = begin;
    }

    public MyPoint getEnd() {
        return end;
    }

    public void setEnd(MyPoint end) {
        this.end = end;
    }

    public int getBeginX() {
        return this.getBegin().getX();
    }

    public void setBeginX(int x) {
        this.begin.setX(x);
    }

    public int getBeginY() {
        return this.getBegin().getY();
    }

    public void setBeginY(int y) {
        this.begin.setY(y);
    }

    public int getEndX() {
        return this.getEnd().getX();
    }

    public void setEndX(int x) {
        this.end.setX(x);
    }

    public int getEndY() {
        return this.getEnd().getY();
    }

    public void setEndY(int y) {
        this.end.setY(y);
    }

    public int[] getBeginXY() {
        int[] XY = new int[2];
        XY[0] = this.getBeginX();
        XY[1] = this.getBeginY();
        return XY;
    }

    public void setBeginXY(int x, int y) {
        this.setBeginX(x);
        this.setBeginY(y);
    }

    public int[] getEndXY() {
        int[] XY = new int[2];
        XY[0] = this.getEndX();
        XY[1] = this.getEndY();
        return XY;
    }

    public void setEndXY(int x, int y) {
        this.setEndX(x);
        this.setEndY(y);
    }

    public double getLength() {
        return this.getBegin().distance(this.getEnd());
    }

    public double getGradient() {
        int xDiff = this.end.getX() - this.begin.getX();
        int yDiff = this.end.getY() - this.begin.getY();
        return Math.atan2(yDiff, xDiff);
    }

    @Override
    public String toString() {
        return "MyLine{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
