package hus.oop.homework3;

import java.util.Arrays;
import java.util.Scanner;

public class GradesStatistics {
    public static void readGrades() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = in.nextInt();
        int[] array = new int[numStudents];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            array[i] = in.nextInt();
        }
        print(array);
        System.out.print("\nThe average is: " + average(array));
        System.out.print("\nThe median is: " + median(array));
        System.out.print("\nThe minimum is: " + min(array));
        System.out.print("\nThe maximum is: " + max(array));
        System.out.printf("\nThe standard deviation is: %.2f", standardDeviation(array));


    }

    public static void print(int[] array) {
        System.out.print("The grades are: ");
        if (array.length == 1) {
            System.out.print("[" + array[0] + "]");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    System.out.print("[" + array[i] + ", ");
                } else if (i == array.length - 1) {
                    System.out.print(array[i] + "]");
                } else {
                    System.out.print(array[i] + ", ");
                }
            }
        }

    }

    public static double average(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    public static double median(int[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            return (double) (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        } else return (double) array[array.length / 2];
    }

    public static int max(int[] array) {
        return array[array.length - 1];
    }

    public static int min(int[] array) {
        return array[0];
    }

    public static double standardDeviation(int[] array) {
        double meanSquare = Math.pow(average(array), 2);
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] * array[i] - meanSquare;
        }
        double result = Math.sqrt((sum) / array.length);
        return result;
    }


    public static void main(String[] args) {
        readGrades();
    }
}
