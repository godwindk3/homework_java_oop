package hus.oop.lab3;

import java.util.Scanner;

public class PerfectPrimeFactorList {
    public static boolean isPrime(int aPosInt) {
        if (aPosInt < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(aPosInt); i++) {
            if (aPosInt % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isProductOfPrimeFactors(int aPosInt) {
        if (aPosInt == 1) {
            return false;
        }
        int product = 1;
        for (int i = 2; i < aPosInt; i++) {
            if (isPrime(i) && (aPosInt % i == 0)) {
                product *= i;
            }
        }
        if (product == aPosInt) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the upper bound: ");
        int upperBound = in.nextInt();

        in.close();
        int count = 0;

        System.out.println("These numbers are equal to the product of prime factors");
        for (int i = 1; i < upperBound; i++) {
            if (isProductOfPrimeFactors(i)) {
                System.out.print(i + " ");
                count += 1;
            }
        }

        System.out.println("[" + count + " numbers found (" + ((float) count / upperBound) * 100 + "%)]");

    }
}
