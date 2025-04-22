package hus.oop.homework5.ex_1_2;


public class TestMain {
    public static void main(String[] args) {
        MyPolynomial myPolynomial1 = new MyPolynomial(1.1, 2.2, 3.3);
        MyPolynomial myPolynomial2 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("My Polynomial 1: " + myPolynomial1);
        System.out.println("My Polynomial 2: " + myPolynomial2);

        System.out.println("My Polynomial 1 degree: " + myPolynomial1.getDegree());
        System.out.println("My Polynomial 2 degree: " + myPolynomial2.getDegree());

        System.out.println("When x = 2: " + myPolynomial1.evaluate(2));
        System.out.println("When x = 2: " + myPolynomial2.evaluate(2));

        System.out.println("Add: " + myPolynomial1.add(myPolynomial2));
        System.out.println("Multiply: " + myPolynomial1.multiply(myPolynomial2));

    }
}
