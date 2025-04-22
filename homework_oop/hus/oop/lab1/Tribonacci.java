package hus.oop.lab1;

public class Tribonacci {
    public static void main(String[] args) {
        int n = 4;
        int fn;
        int fnMinus1 = 1;
        int fnMinus2 = 1;
        int fnMinus3 = 2;
        int nMax = 20;
        int sum = fnMinus1 + fnMinus2 + fnMinus3;
        double average;

        System.out.println("The first " + nMax + " Triibonacci numbers are: ");


        while (n < nMax) {
            fn = fnMinus1 + fnMinus2 + fnMinus3;
            System.out.println("The hus.oop.lab1.Tribonacci " + n + " th is: " + fn);
            ++n;
            fnMinus1 = fnMinus2;
            fnMinus2 = fnMinus3;
            fnMinus3 = fn;

        }
    }
}
