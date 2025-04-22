package hus.oop.lab5.ex_2_1;

public class TestLineSub {
    public static void main(String[] args) {

        LineSub line1 = new LineSub(1, 2, 4, 6);
        System.out.println("Line 1: " + line1);
        System.out.println("Begin: " + line1.getBegin());
        System.out.println("End: " + line1.getEnd());
        System.out.println("Length: " + line1.getLength());
        System.out.println("Gradient: " + line1.getGradient());


        Point p1 = new Point(3, 5);
        Point p2 = new Point(7, 10);
        LineSub line2 = new LineSub(p1, p2);
        System.out.println("\nLine 2: " + line2);
        System.out.println("Begin: " + line2.getBegin());
        System.out.println("End: " + line2.getEnd());
        System.out.println("Length: " + line2.getLength());
        System.out.println("Gradient: " + line2.getGradient());

        line1.setBeginXY(0, 0);
        line1.setEndXY(3, 4);
        System.out.println("\nAfter modifying Line 1:");
        System.out.println("Line 1: " + line1);
        System.out.println("Length: " + line1.getLength());
        System.out.println("Gradient: " + line1.getGradient());
    }
}
