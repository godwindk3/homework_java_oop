package hus.oop.homework2;

import java.util.Scanner;

public class StringAndCharacterHomework {
    public static String exchangeCipher(String inStr) {
        String ciphertext = "";
        char cipherChar;
        for (int i = 0; i < inStr.length(); i++) {
            cipherChar = (char) ('A' + 'Z' - inStr.charAt(i));
            ciphertext += cipherChar;
        }

        return ciphertext;
    }

    public static void testExchangeCipher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a plaintext string: ");
        String inStr = in.next().toUpperCase();
        System.out.println("The ciphertext string is: " + exchangeCipher(inStr));
//        in.close();

    }

    public static boolean isPalindromicWord(String inStr) {

        for (int fIdx = 0, bIdx = inStr.length() - 1; fIdx < bIdx; fIdx++, bIdx--) {
            if (inStr.charAt(fIdx) != inStr.charAt(bIdx)) {
                return false;
            }
        }

        return true;
    }

    public static void testPalindromicWord() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inStr = in.next();
        if (isPalindromicWord(inStr)) {
            System.out.print("\n" + "\"" + inStr + "\"" + " is a palindromic word");
        } else {
            System.out.print("\n" + "\"" + inStr + "\"" + " is NOT a palindromic word");
        }
    }

    public static boolean isPalindromicPhrase(String inStr) {
        String cleaned = inStr.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//        System.out.print(cleaned);
        if (isPalindromicWord(cleaned)) {
            return true;
        } else {
            return false;
        }
    }

    public static void testPalindromicPhrase() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inStr = in.nextLine();
        if (isPalindromicPhrase(inStr)) {
            System.out.print("\n" + "\"" + inStr + "\"" + " is a palindromic phrase");
        } else {
            System.out.print("\n" + "\"" + inStr + "\"" + " is NOT a palindromic phrase");
        }
    }


    public static void main(String[] args) {
//        testExchangeCipher();
//        testPalindromicWord();
        testPalindromicPhrase();
    }
}
