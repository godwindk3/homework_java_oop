package hus.oop.lab5.ex_1_1;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        System.out.println("Cylinder:"
                + " radius=" + cylinder1.getRadius()
                + " height=" + cylinder1.getHeight()
                + " base area=" + cylinder1.getArea()
                + " volume=" + cylinder1.getVolume());
        System.out.println(cylinder1.toString());

        Cylinder cylinder2 = new Cylinder(10.0);
        System.out.println("Cylinder:"
                + " radius=" + cylinder2.getRadius()
                + " base area=" + cylinder2.getArea()
                + " volume=" + cylinder2.getVolume());
        System.out.println(cylinder2.toString());

        Cylinder cylinder3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder:"
                + " radius=" + cylinder3.getRadius()
                + " base area=" + cylinder3.getArea()
                + " volume=" + cylinder3.getVolume());
        System.out.println(cylinder3.toString());


    }
}
