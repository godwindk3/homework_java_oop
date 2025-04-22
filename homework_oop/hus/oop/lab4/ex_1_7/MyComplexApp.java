package hus.oop.lab4.ex_1_7;

import java.util.Scanner;

public class MyComplexApp {
    // This is also a test driver :V
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter complex number 1 (real and imaginary part split by space): ");
        double real1 = in.nextDouble();
        double imag1 = in.nextDouble();

        System.out.print("Enter complex number 2 (real and imaginary part split by space): ");
        double real2 = in.nextDouble();
        double imag2 = in.nextDouble();

        MyComplex number1 = new MyComplex(real1, imag1);
        MyComplex number2 = new MyComplex(real2, imag2);

        System.out.println("Number 1 is: " + number1.toString());
        if (number1.isReal()) {
            System.out.println(number1.toString() + " is a pure real number");
        } else {
            System.out.println(number1.toString() + " is NOT a pure real number");
        }
        if (number1.isImaginary()) {
            System.out.println(number1.toString() + " is a pure imaginary number");
        } else {
            System.out.println(number1.toString() + " is NOT a pure imaginary number");
        }

        System.out.println("Number 2 is: " + number2.toString());
        if (number2.isReal()) {
            System.out.println(number2.toString() + " is a pure real number");
        } else {
            System.out.println(number2.toString() + " is NOT a pure real number");
        }
        if (number2.isImaginary()) {
            System.out.println(number2.toString() + " is a pure imaginary number");
        } else {
            System.out.println(number2.toString() + " is NOT a pure imaginary number");
        }


        if (number1.equals(number2)) {
            System.out.println(number1.toString() + " is equal to " + number2.toString());
        } else {
            System.out.println(number1.toString() + " is NOT equal to " + number2.toString());
        }
        System.out.println(number1.toString() + " + " + number2.toString() + " = " + number1.addNew(number2).toString());
        System.out.println(number1.toString() + " - " + number2.toString() + " = " + number1.subtractNew(number2).toString());
        System.out.println(number1.toString() + " * " + number2.toString() + " = " + number1.multiply(number2).toString());
        System.out.println(number1.toString() + " / " + number2.toString() + " = " + number1.divide(number2).toString());
        System.out.println("Radians of number 1: " + number1.argument());
        System.out.println("Radians of number 2: " + number2.argument());

        System.out.println("Conjugate of number 1: " + number1.conjugate());
        System.out.println("Conjugate of number 2: " + number2.conjugate());


    }
}
