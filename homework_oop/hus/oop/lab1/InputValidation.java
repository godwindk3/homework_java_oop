package hus.oop.lab1;

import java.util.Scanner;

public class InputValidation {
    public static void main(String[] args) {
        int numberIn;
        boolean isValid;

        isValid = false;
        Scanner in = new Scanner(System.in);
        do {

            System.out.print("Enter a number between 0-10 or 90-100: ");
            numberIn = in.nextInt();
            if (((0 <= numberIn) && (10 >= numberIn)) || ((numberIn >= 90) && (numberIn <= 100))) {
                System.out.print("You have entered: " + numberIn);
                isValid = true;
            } else {
                System.out.println("Invalid input, try again...");
            }

        } while (!isValid);

        in.close();
    }
}
