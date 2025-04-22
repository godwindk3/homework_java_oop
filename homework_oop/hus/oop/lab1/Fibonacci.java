package hus.oop.lab1;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        int fn;
        int fnMinus1 = 1;
        int fnMinus2 = 1;
        int nMax = 20;
        int sum = fnMinus1 + fnMinus2;
        double average;

        System.out.println("The first " + nMax + " hus.oop.lab1.Fibonacci numbers are: ");
        System.out.println("The fibonacci " + 1 + " th is: " + 1);
        System.out.println("The fibonacci " + 2 + " th is: " + 1);


        while (n < nMax) {
            fn = fnMinus1 + fnMinus2;
            System.out.println("The fibonacci " + n + " th is: " + fn);
            ++n;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;

        }
    }
}
