package hus.oop.lab1;

import java.util.Scanner;

public class ReverseInt {
    public static void main(String[] args) {
        int inNumber;
        int inDigit;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        inNumber = in.nextInt();
        System.out.print("Reverse is: ");
        while (inNumber > 0) {
            inDigit = inNumber % 10;
            System.out.print(inDigit);
            inNumber /= 10;
        }

        in.close();
    }
}


