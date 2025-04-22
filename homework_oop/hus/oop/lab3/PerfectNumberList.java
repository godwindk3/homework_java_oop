package hus.oop.lab3;

import java.util.Scanner;

public class PerfectNumberList {
    public static boolean isPerfect(int aPosInt) {
        int sum = 0;
        for (int i = 1; i < aPosInt; i++) {
            if (aPosInt % i == 0) {
                sum += i;
            }
        }
        if (sum == aPosInt) {
            return true;
        }
        return false;
    }

    public static boolean isDeficient(int aPosInt) {
        int sum = 0;
        for (int i = 1; i < aPosInt; i++) {
            if (aPosInt % i == 0) {
                sum += i;
            }
        }
        if (sum < aPosInt) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the upper bound: ");
        int upperBound = in.nextInt();
        in.close();
        System.out.println("These numbers are perfect: ");
        int count = 0;
        for (int i = 1; i <= upperBound; i++) {
            if (isPerfect(i)) {
                System.out.print(i + " ");
                count += 1;
            }
        }
        System.out.println();
        System.out.println("[" + count + " perfect numbers found (" + ((float) count / upperBound) * 100 + "%)]");

        count = 0;
        System.out.println("These numbers are neither deficient nor perfect");
        for (int i = 1; i <= upperBound; i++) {
            if (!isPerfect(i) && !isDeficient(i)) {
                System.out.print(i + " ");
                count += 1;
            }
        }
        System.out.println();
        System.out.println("[" + count + " numbers found (" + ((float) count / upperBound) * 100 + "%)]");
    }
}
