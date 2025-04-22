package hus.oop.homework5.ex_1_1;


public class TestMyComplex {

    public static void main(String[] args) {
        // Create two complex numbers
        MyComplex c1 = new MyComplex(3.0, 4.0);
        MyComplex c2 = new MyComplex(1.0, 2.0);

        // Test toString method
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        // Test isReal and isImaginary methods
        System.out.println("c1 is real? " + c1.isReal());
        System.out.println("c1 is imaginary? " + c1.isImaginary());
        System.out.println("c2 is real? " + c2.isReal());

        // Test equals method
        MyComplex c3 = new MyComplex(3.0, 4.0);
        System.out.println("c1 equals c3? " + c1.equals(c3));
        System.out.println("c1 equals c2? " + c1.equals(c2));

        // Test magnitude and argument methods
        System.out.println("Magnitude of c1: " + c1.magnitude());
        System.out.println("Argument of c1: " + c1.argument());

        // Test add and addNew methods
        MyComplex c4 = c1.addNew(c2);
        System.out.println("c1 + c2 = " + c4);
        c1.add(c2);
        System.out.println("c1 after adding c2: " + c1);

        // Test subtractNew method
        MyComplex c5 = c1.subtractNew(c2);
        System.out.println("c1 - c2 = " + c5);

        // Test multiply method
        MyComplex c6 = c1.multiply(c2);
        System.out.println("c1 * c2 = " + c6);

        // Test divide method
        MyComplex c7 = c1.divide(c2);
        System.out.println("c1 / c2 = " + c7);

        // Test conjugate method
        MyComplex c8 = c1.conjugate();
        System.out.println("Conjugate of c1: " + c8);

    }
}
