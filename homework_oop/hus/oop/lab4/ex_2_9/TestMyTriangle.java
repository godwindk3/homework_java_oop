package hus.oop.lab4.ex_2_9;

public class TestMyTriangle {
    public static void main(String[] args) {
        // Test Isosceles
        MyTriangle t1 = new MyTriangle(0, 0, 1, 0, 0, 1);
        System.out.println(t1 + " -> " + t1.getType()); // Expected: Equilateral

        // Test Scalene
        MyTriangle t2 = new MyTriangle(0, 0, 1, 0, 0, 2);
        System.out.println(t2 + " -> " + t2.getType()); // Expected: Isosceles

        // Test Isosceles
        MyTriangle t3 = new MyTriangle(0, 0, 2, 0, 1, 3);
        System.out.println(t3 + " -> " + t3.getType()); // Expected: Scalene

    }
}
