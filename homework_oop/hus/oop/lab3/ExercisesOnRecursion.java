package hus.oop.lab3;

import java.util.Scanner;

public class ExercisesOnRecursion {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void testFactorial() {
        Scanner in = new Scanner(System.in);
        int numberIn;

        System.out.print("Enter a number: ");
        numberIn = in.nextInt();

        in.close();

        System.out.println("The factorial of " + numberIn + " is: " + factorial(numberIn));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + factorial(n - 2);
        }
    }

    public static void testFibonacci() {
        Scanner in = new Scanner(System.in);
        int numberIn;
        System.out.print("Enter a number: ");

        numberIn = in.nextInt();

        in.close();

        System.out.println("The " + numberIn + "th fibonacci is: " + fibonacci(numberIn));
    }

    public static int numOfDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int lenS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return lenS(n - 1) + numOfDigits(n);
        }
    }

    public static void testLenS() {
        Scanner in = new Scanner(System.in);
        int numberIn;

        System.out.print("Enter a number: ");
        numberIn = in.nextInt();

        in.close();

        System.out.println("Length of S(" + numberIn + ") is: " + lenS(numberIn));

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void testGcd() {
        Scanner in = new Scanner(System.in);
        int a;
        int b;

        System.out.print("Enter 2 number split by space: ");

        a = in.nextInt();
        b = in.nextInt();

        in.close();

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }


    public static void main(String[] args) {
//        testFactorial();
//        testFibonacci();
//        testLenS();
        testGcd();
    }

}
