package hus.oop.lab1;

import java.util.Scanner;

public class SumProductMinMax5 {
    public static void main(String[] args) {
        int number1;
        int number2;
        int number3;
        int number4;
        int number5;

        int sum;
        int product;
        int min;
        int max;

        Scanner in = new Scanner(System.in);

        System.out.print("Number 1: ");
        number1 = in.nextInt();

        System.out.print("Number 2: ");
        number2 = in.nextInt();

        System.out.print("Number 3: ");
        number3 = in.nextInt();

        System.out.print("Number 4: ");
        number4 = in.nextInt();

        System.out.print("Number 5: ");
        number5 = in.nextInt();

        in.close();

        sum = number1 + number2 + number3 + number4 + number5;
        product = number1 * number2 * number3 * number4 * number5;
        min = number1;
        if (number2 < min) {
            min = number2;
        }
        if (number3 < min) {
            min = number3;
        }
        if (number4 < min) {
            min = number4;
        }
        if (number5 < min) {
            min = number5;
        }

        max = number1;
        if (number2 > max) {
            max = number2;
        }
        if (number3 > max) {
            max = number3;
        }
        if (number4 > max) {
            max = number4;
        }
        if (number5 > max) {
            max = number5;
        }

        System.out.println("Sum: " + sum + " Product: " + product + " Min: " + min + " Max: " + max);
    }
}
