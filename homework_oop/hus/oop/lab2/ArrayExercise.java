package hus.oop.lab2;

import java.util.Scanner;

public class ArrayExercise {
    public static int[] createArray(Scanner in) {
        final int NUM_ITEMS;
        int[] items;


        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();

        items = new int[NUM_ITEMS];

        System.out.print("Enter the value of all items (separated by space): ");
        if (items.length > 0) {
            for (int i = 0; i < items.length; ++i) {
                items[i] = in.nextInt();
            }
        }

        return items;
    }

    public static void printArray(int[] items) {

        for (int i = 0; i < items.length; ++i) {
            if (i == 0) {
                System.out.print("[" + items[i]);
            } else if (i == items.length - 1) {
                System.out.println(", " + items[i] + "]");
            } else {
                System.out.print(", " + items[i]);
            }

        }
    }

    public static void testCreateAndPrintArray() {
        Scanner in = new Scanner(System.in);

        int[] myArray = createArray(in);
        System.out.print("The values are: ");
        printArray(myArray);

        in.close();
    }

    public static int[] generateStudentGrades(Scanner in) {
        int numStudents;
        int[] studentGrades;

        do {
            System.out.print("Enter the number of students: ");
            numStudents = in.nextInt();
        } while (numStudents < 0);

        studentGrades = new int[numStudents];

        for (int i = 0; i < numStudents; ++i) {
            int grade;
            do {
                System.out.print("Enter the grade for student " + (i + 1) + " (0-100): ");
                grade = in.nextInt();
            } while (grade < 0 || grade > 100);

            studentGrades[i] = grade;
        }

        return studentGrades;
    }

    public static void simpleGradesStatistics(int[] grades) {
        int sum = 0;
        int min = grades[0];
        int max = grades[0];

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
            if (grades[i] < min) {
                min = grades[i];
            }
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        double average = (double) sum / grades.length;

        System.out.printf("The average is: %.2f\n", average);
        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);

    }

    public static void testSimpleGradesStatistics() {
        Scanner in = new Scanner(System.in);
        int[] grades = generateStudentGrades(in);
        simpleGradesStatistics(grades);
        in.close();
    }

    public static String hexadecimalToBinary(String hexStr) {

        String[] HEX_BITS = {
                "0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111"
        };

        StringBuilder binaryStr = new StringBuilder();

        for (int i = 0; i < hexStr.length(); i++) {
            char hexChar = Character.toUpperCase(hexStr.charAt(i));

            int decimalValue;
            if (hexChar >= '0' && hexChar <= '9') {
                decimalValue = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                decimalValue = hexChar - 'A' + 10;
            } else {
                return "Invalid";
            }
            binaryStr.append(HEX_BITS[decimalValue] + " ");
        }

        return binaryStr.toString();
    }

    public static void testHexadecimalToBinary() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Hexadecimal string: ");

        String hexInput = in.next();

        String binaryOutput = hexadecimalToBinary(hexInput);

        System.out.println("The equivalent binary for hexadecimal" + " \"" + hexInput + "\" " + "is: " + binaryOutput);

        in.close();


    }

    public static String decimalToHexadecimal(int positiveInteger) {
        String hexCharacter = "0123456789ABCDEF";
        String hexResult = "";
        while (positiveInteger > 0) {
            int remainder = positiveInteger % 16;
            hexResult = hexCharacter.charAt(remainder) + hexResult;
            positiveInteger = positiveInteger / 16;
        }
        return hexResult;
    }

    public static void testDecimalToHexadecimal() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = in.nextInt();
        in.close();

        String hexStr = decimalToHexadecimal(decimalNumber);
        System.out.println("The equivalent hexadecimal number is " + hexStr);
    }



    public static void main(String[] args) {
//        testCreateAndPrintArray();
//        testSimpleGradesStatistics();
//        testHexadecimalToBinary();
//        testDecimalToHexadecimal();

    }
}
