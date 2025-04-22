package hus.oop.lab5.ex_1_3;

public class TestMain {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3.0f, 4.0f);
        System.out.println("Point2D: " + point2D);
        point2D.setXY(5.0f, 6.0f);
        System.out.println("After setXY: " + point2D);
        float[] xy = point2D.getXY();
        System.out.println("getXY: (" + xy[0] + ", " + xy[1] + ")");

        // Test Point3D
        Point3D point3D = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Point3D: " + point3D);
        point3D.setXYZ(4.0f, 5.0f, 6.0f);
        System.out.println("After setXYZ: " + point3D);
        float[] xyz = point3D.getXYZ();
        System.out.println("getXYZ: (" + xyz[0] + ", " + xyz[1] + ", " + xyz[2] + ")");

        // Test default constructor
        Point3D defaultPoint = new Point3D();
        System.out.println("Default Point3D: " + defaultPoint);
    }
}
