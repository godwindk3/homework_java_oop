package hus.oop.lab4.ex_2_9;


public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }

    public double getPerimeter() {
        double edge1 = this.v1.distance(this.v2);
        double edge2 = this.v2.distance(this.v3);
        double edge3 = this.v3.distance(this.v1);

        return edge1 + edge2 + edge3;
    }

    public String getType() {
        double edge1 = this.v1.distance(this.v2);
        double edge2 = this.v2.distance(this.v3);
        double edge3 = this.v3.distance(this.v1);

        double epsilon = 0.0000001;

        if (Math.abs(edge1 - edge2) < epsilon && Math.abs(edge2 - edge3) < epsilon) {
            return "Equilateral";
        } else if (Math.abs(edge1 - edge2) < epsilon || Math.abs(edge2 - edge3) < epsilon || Math.abs(edge1 - edge3) < epsilon) {
            return "Isosceles";
        } else {
            return "Scalene";
        }

    }
}
