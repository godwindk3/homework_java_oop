package hus.oop.homework3;

import java.util.Scanner;

public class GradesHistogram {
    public static void testHistogramPrint() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = in.nextInt();
        int[] array = new int[numStudents];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter the grade for student (0-100) " + (i + 1) + ": ");
            array[i] = in.nextInt();
        }
        int[] frequency = frequency(array);
        printHorizontalHistogram(array, frequency);
        System.out.println();
        printVerticalHistogram(array, frequency);
    }

    public static int[] frequency(int[] array) {
        int[] frequency = new int[10];
        for (int grade : array) {
            if (grade >= 90) {
                frequency[9]++;
            } else {
                frequency[grade / 10]++;
            }
        }
        return frequency;
    }

    public static void printHorizontalHistogram(int[] array, int[] frequency) {
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                System.out.print("90-100 : ");
            } else {
                System.out.printf("%2d-%2d  : ", i * 10, i * 10 + 9);
            }
            for (int j = 0; j < frequency[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printVerticalHistogram(int[] array, int[] frequency) {
        int maxFrequency = 0;
        for (int freq : frequency) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }
        for (int row = maxFrequency; row > 0; row--) {
            for (int i = 0; i < 10; i++) {
                if (frequency[i] >= row) {
                    System.out.print("  *   ");
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
        }


        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                System.out.print("90-100");
            } else {
                System.out.printf("%2d-%2d", i * 10, i * 10 + 9);
            }
            System.out.print(" ");
        }

    }

    public static void main(String[] args) {
        testHistogramPrint();

    }
}
