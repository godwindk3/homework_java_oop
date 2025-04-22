package hus.oop.homework2;

import java.util.Scanner;

public class WordGuess {
    public static void guessWord() {
        final String SECRET_WORD = "testing";
        Scanner in = new Scanner(System.in);
        guessWord(SECRET_WORD, in);
        in.close();

    }

    public static void guessWord(String guessedString, Scanner in) {
        boolean[] wordCheck = new boolean[guessedString.length()];
        String key;
        for (int i = 0; i < guessedString.length(); i++) {
            wordCheck[i] = false;
        }
        int count = 0;
        int trials = 1;
        boolean check = false;
        while (check == false) {
            System.out.println("Key in one character or your guess word (If not your guess word or one key, I will take first character of the string): ");
            key = in.next();
            if (key.equals(guessedString)) {
                System.out.print("\nCongratulation!\nYou got in " + trials + " trials");
                check = true;
            } else {
                for (int i = 0; i < guessedString.length(); i++) {
                    if (key.charAt(0) == guessedString.charAt(i)) {
                        wordCheck[i] = true;
                    }
                }

                System.out.println("Trial " + trials + ": ");

                for (int i = 0; i < guessedString.length(); i++) {
                    if (wordCheck[i] == true) {
                        System.out.print(guessedString.charAt(i));
                        count++;
                        if (count == guessedString.length()) {
                            System.out.println("\nCongratulation! \nYou got it in " + trials + " trials");
                            check = true;
                        }
                    } else {
                        System.out.print("_");
                    }
                }
                System.out.println("");
                trials++;
                count = 0;
            }
        }
    }


    public static void main(String[] args) {
        guessWord();

    }
}
