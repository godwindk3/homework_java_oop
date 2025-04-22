package hus.oop.homework2;

import java.util.Scanner;

public class ArrayHomework {
    public static void printArrayStars(Scanner in) {
        final int NUM_ITEMS = in.nextInt();
        int[] items = new int[NUM_ITEMS];
        System.out.print("Enter the value of all items (separated by space): ");
        for (int i = 0; i < NUM_ITEMS; i++) {
            items[i] = in.nextInt();
        }
        for (int i = 0; i < items.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < items[i]; j++) {
                System.out.print("*");
            }
            System.out.print("(" + items[i] + ")\n");
        }

    }

    public static void testPrintArrayStars() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        printArrayStars(in);
    }

    public static void main(String[] args) {
        testPrintArrayStars();

    }
}
