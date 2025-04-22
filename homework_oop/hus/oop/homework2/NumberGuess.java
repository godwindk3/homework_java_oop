package hus.oop.homework2;

import java.util.Scanner;

public class NumberGuess {
    public static void guessNumber() {
        final int SECRET_NUMBER = (int) (Math.random() * 100);
//        System.out.print(SECRET_NUMBER);
        Scanner in = new Scanner(System.in);
        guessNumber(SECRET_NUMBER, in);
        in.close();

    }

    public static void guessNumber(int number, Scanner in) {
        boolean state = false;
        System.out.println("Key in your guess: ");
        int key = in.nextInt();
        int trials = 1;
        while (state == false) {
            if (key == number) {
                System.out.print("You got it in " + trials + " trials!");
                break;
            } else if (key > number) {
                System.out.println("Try lower: ");
                key = in.nextInt();
            } else {
                System.out.println("Try higher: ");
                key = in.nextInt();
            }
            trials++;
        }

    }

    public static void main(String[] args) {
        guessNumber();
    }
}
