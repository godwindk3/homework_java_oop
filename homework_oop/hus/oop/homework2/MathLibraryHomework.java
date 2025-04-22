package hus.oop.homework2;

import java.util.Scanner;

public class MathLibraryHomework {
    public static double sin(double x, int numTerms) {
        double sin = 0;
        double temp = 1;
        for (int i = 1; i <= numTerms; i++) {
            temp *= (x / i);
            if (i % 2 != 0) {
                sin += temp;
            } else {
                temp *= -1;
            }

        }
        return sin;
    }

    public static double cos(double x, int numTerms) {
        double temp = 1.0;
        double cos = 0;
        for (int i = 1; i < numTerms; i++) {
            temp *= (x / i);
            if (i % 2 == 0) {
                cos += temp;
            } else {
                temp *= -1;
            }
        }
        cos = 1 + cos;
        return cos;
    }

    public static void testTrigonometric() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = in.nextDouble();
        System.out.print("Enter num terms: ");
        int numTerms = in.nextInt();
        System.out.println("-------------------------- SIN: \n Library");
        System.out.println(Math.sin(x));
        System.out.println("My calculate: ------------");
        System.out.println(sin(x, numTerms));
        System.out.println("-------------------------- COS: \n Library");
        System.out.println(Math.cos(x));
        System.out.println("My calculate: ------------");
        System.out.println(cos(x, numTerms));

    }

    public static double specialSeries(double x, int numTerms) {
        double temp = 1;
        double sum = 0;
        for (int i = 1; i <= numTerms; i++) {
            temp *= x;
            if (i % 2 != 0) {
                sum += temp / i;
            } else {
                temp *= (double) (i - 1) / i;
            }
        }
        return sum;
    }

    public static void testSpecialSeries() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = in.nextDouble();
        System.out.print("\nEnter num terms: ");
        int numTerms = in.nextInt();
        System.out.print("\nResult: " + specialSeries(x, numTerms));
    }

    public static void factorialInt() {
        int factorial = 1;
        int count = 1;
        boolean check = false;
        while (check == false) {
            System.out.println("The factorial of " + count + " is: " + factorial);
            if ((Integer.MAX_VALUE / factorial) < (count + 1)) {
                System.out.println("The factorial of " + (count + 1) + " is out of range");
                check = true;
            } else {
                count++;
                factorial = factorial * count;
            }

        }
    }

    public static void fibonacciInt() {
        int f_n_2 = 1;
        int f_n_1 = 1;
        int f_n = 0;
        int count = 2;
        boolean check = false;

        System.out.println("F(0) is: " + f_n_2);
        System.out.println("F(1) is: " + f_n_1);

        while (check == false) {
            if (Integer.MAX_VALUE - f_n_1 < f_n_2) {
                System.out.print("F(" + count + ") is out of the range of int");
                check = true;
            } else {
                f_n = f_n_1 + f_n_2;
                System.out.println("F(" + count + ") is: " + f_n);
                f_n_2 = f_n_1;
                f_n_1 = f_n;
                count++;

            }
        }
    }

    public static String toRadix(String in, int inRadix, int outRadix) {

        if (inRadix < 2 || inRadix > 36 || outRadix < 2 || outRadix > 36) {
            throw new IllegalArgumentException("Radix must be between 2 and 36");
        }
        if (in == null || in.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        long decimal = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = Character.toUpperCase(in.charAt(i));
            int digit = charToDigit(c);
            if (digit >= inRadix) {
                throw new IllegalArgumentException("Invalid digit '" + c + "' for radix " + inRadix);
            }
            decimal = decimal * inRadix + digit;
        }


        if (decimal < 0) {
            throw new IllegalArgumentException("Input must be a positive integer");
        }


        if (decimal == 0) {
            return "0";
        }


        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int remainder = (int) (decimal % outRadix);
            char digitChar = digitToChar(remainder);
            result.insert(0, digitChar);
            decimal /= outRadix;
        }

        return result.toString().toLowerCase();
    }

    private static int charToDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
        }
    }

    private static char digitToChar(int digit) {
        if (digit >= 0 && digit <= 9) {
            return (char) (digit + '0');
        } else if (digit >= 10 && digit <= 35) {
            return (char) (digit - 10 + 'A');
        } else {
            throw new IllegalArgumentException("Invalid digit for conversion: " + digit);
        }
    }


    public static void main(String[] args) {
//        testTrigonometric();
//        testSpecialSeries();
//        factorialInt();
//        fibonacciInt();

        System.out.println(toRadix("1010", 2, 10));
        System.out.println(toRadix("1A", 16, 2));
        System.out.println(toRadix("255", 10, 16));
        System.out.println(toRadix("123", 4, 8));
        System.out.println(toRadix("0", 10, 2));

    }

}
