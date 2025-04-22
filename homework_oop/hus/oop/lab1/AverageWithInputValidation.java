package hus.oop.lab1;

import java.util.Scanner;

public class AverageWithInputValidation {
    public static void main(String[] args) {
        final int NUMSTUDENTS = 3;
        int numberIn;
        boolean isValid;
        int sum = 0;
        double average;
        Scanner in = new Scanner(System.in);

        for (int studentNo = 1; studentNo <= NUMSTUDENTS; ++studentNo) {
            isValid = false;

            do {
                System.out.print("Enter the mark(0 - 100) for student " + studentNo + ": ");
                numberIn = in.nextInt();

                if ((numberIn >= 0) && (numberIn <= 100)) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input, try again...");
                }

            } while (!isValid);

            sum += numberIn;
        }
        in.close();

        System.out.printf("Average: %.2f%n ", (sum / 3.0));

    }
}
