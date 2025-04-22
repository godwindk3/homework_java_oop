package hus.oop.lab1;

public class Factorial {
    public static void main(String[] args) {
        int n = 20;
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }

        System.out.println("The hus.oop.lab1.Factorial of " + n + " is " + factorial);
    }
}