package hus.oop.lab5.ex_2_1;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        System.out.println(p1);
        p1.setXY(100, 10);

        System.out.println("After set " + p1);
    }
}
