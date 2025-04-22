package hus.oop.lab2;

import java.util.Scanner;

public class StringAndCharacterExercise {
    public static String reverseString(String inStr) {
        String reverseStr = "";
        int inStrLen = inStr.length();

        for (int charIdx = inStrLen - 1; charIdx >= 0; --charIdx) {
            reverseStr += inStr.charAt(charIdx);
        }

        return reverseStr;
    }

    public static void testReverseString() {
        String inStr;


        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String: ");
        inStr = in.next();

        in.close();

        System.out.print("The reverse of the String " + "\"" + inStr + "\"" + " is " + "\"" + reverseString(inStr) + "\".");
    }

    public static int countVowels(String inStr) {
        int count = 0;
        String vowelsStr = "aeiou";

        for (int inStrIdx = 0; inStrIdx < inStr.length(); ++inStrIdx) {
            char ch = inStr.charAt(inStrIdx);
            for (int vowelsIdx = 0; vowelsIdx < vowelsStr.length(); ++vowelsIdx) {
                if (ch == vowelsStr.charAt(vowelsIdx)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int countDigits(String inStr) {
        int count = 0;

        for (int inStrIdx = 0; inStrIdx < inStr.length(); inStrIdx++) {
            char currentChar = inStr.charAt(inStrIdx);
            boolean isDigit = false;

            for (char digit = '0'; digit <= '9'; ++digit) {
                if (currentChar == digit) {
                    isDigit = true;
                    break;
                }
            }
            if (isDigit) {
                count++;
            }
        }
        return count;
    }

    public static void testCountVowelsDigits() {
        String inStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        inStr = in.next().toLowerCase();

        in.close();

        int vowelCount = countVowels(inStr);
        int digitCount = countDigits(inStr);
        int inStrLength = inStr.length();

        double vowelPercentage;
        if (inStrLength == 0) {
            vowelPercentage = 0;
        } else {
            vowelPercentage = ((double) vowelCount / inStrLength) * 100;
        }

        double digitPercentage;
        if (inStrLength == 0) {
            digitPercentage = 0;
        } else {
            digitPercentage = ((double) digitCount / inStrLength) * 100;
        }
        System.out.printf("Number of vowels: %d (%.2f%%)%n", vowelCount, vowelPercentage);
        System.out.printf("Number of digits: %d (%.2f%%)%n", digitCount, digitPercentage);

    }

    public static String phoneKeyPad(String inStr) {
        String keypadDigits = "";
        for (int inStrIdx = 0; inStrIdx < inStr.length(); ++inStrIdx) {
            char currentChar = inStr.charAt(inStrIdx);

            switch (currentChar) {
                case 'a':
                case 'b':
                case 'c':
                    keypadDigits += '2';
                    break;
                case 'd':
                case 'e':
                case 'f':
                    keypadDigits += '3';
                    break;
                case 'g':
                case 'h':
                case 'i':
                    System.out.print(4);
                    keypadDigits += '4';
                    break;
                case 'j':
                case 'k':
                case 'l':
                    keypadDigits += '5';
                    break;
                case 'm':
                case 'n':
                case 'o':
                    keypadDigits += '6';
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':
                    keypadDigits += '7';
                    break;
                case 't':
                case 'u':
                case 'v':
                    keypadDigits += '8';
                    break;
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    keypadDigits += '9';
                    break;
                default:
                    keypadDigits += 'e';
            }
        }
        return keypadDigits;
    }

    public static void testPhoneKeyPad() {
        String inStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String: ");
        inStr = in.next().toLowerCase();

        in.close();

        System.out.print("The phone keypad is: " + phoneKeyPad(inStr));
    }

    public static String cipherCaesarCode(String inStr) {
        inStr = inStr.toUpperCase();
        String result = "";

        for (int i = 0; i < inStr.length(); i++) {
            char ch = inStr.charAt(i);
            char shifted;

            if (ch >= 'A' && ch <= 'Z') {
                shifted = (char) (ch + 3);
                if (shifted > 'Z') {
                    shifted = (char) (shifted - 26);
                }
            } else {
                shifted = ch;
            }
            result += shifted;
        }

        return result;
    }

    public static void testCipherCaesarCode() {
        String inStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a plaintext string: ");

        inStr = in.next();
        in.close();

        System.out.println("The ciphertext string is: " + cipherCaesarCode(inStr));
    }

    public static String decipherCaesarCode(String inStr) {
        inStr = inStr.toUpperCase();
        String result = "";

        for (int i = 0; i < inStr.length(); i++) {
            char ch = inStr.charAt(i);
            char shifted;

            if (ch >= 'A' && ch <= 'Z') {
                shifted = (char) (ch - 3);
                if (shifted < 'A') {
                    shifted = (char) (shifted + 26);
                }
            } else {
                shifted = ch;
            }
            result += shifted;
        }
        return result;
    }

    public static void testDecipherCaesarCode() {
        String inStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a ciphertext string: ");

        inStr = in.next();
        in.close();

        System.out.println("The plaintext string is: " + decipherCaesarCode(inStr));

    }

    public static boolean isHexString(String hexStr) {
        for (int i = 0; i < hexStr.length(); i++) {
            char c = hexStr.charAt(i);

            if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'F' || c >= 'a' && c <= 'f')) {
                return false;
            }
        }
        return true;
    }

    public static void testIsHexString() {
        String hexStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a hex string: ");

        hexStr = in.next();

        if (isHexString(hexStr)) {
            System.out.print("\"" + hexStr + "\" is a hex string");
        } else {
            System.out.print("\"" + hexStr + "\" is not a hex string");
        }

    }

    public static int binaryToDecimal(String binStr) {
        int decimal = 0;
        int power = 1;

        for (int i = binStr.length() - 1; i >= 0; --i) {
            char bit = binStr.charAt(i);
            if (bit == '1') {
                decimal += power;
            }
            power *= 2;

        }
        return decimal;
    }

    public static void testBinaryToDecimal() {
        String binStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Binary string: ");

        binStr = in.next();
        if (!binStr.matches("[01]+")) {
            System.out.print("error: Invalid binary string " + "\"" + binStr + "\"");
            return;
        }

        int decimal = binaryToDecimal(binStr);
        System.out.println("The equivalent decimal number for binary " + "\"" + binStr + "\" is: " + decimal);
    }

    public static int hexadecimalToDecimal(String hexStr) {
        int decimal = 0;
        int power = 1;

        for (int i = hexStr.length() - 1; i >= 0; --i) {
            char hexChar = hexStr.charAt(i);
            int value;

            if (hexChar >= '0' && hexChar <= '9') {
                value = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                value = hexChar - 'A' + 10;
            } else if (hexChar >= 'a' && hexChar <= 'f') {
                value = hexChar - 'a' + 10;
            } else {
                return -1;
            }
            decimal += value * power;
            power *= 16;
        }
        return decimal;
    }

    public static void testHexadecimalToDecimal() {
        String hexStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Hexadecimal string: ");

        hexStr = in.next();
        int decimal = hexadecimalToDecimal(hexStr);
        if (decimal == -1) {
            System.out.print("error: invalid hexadecimal string " + "\"" + hexStr + "\"");
        } else {
            System.out.println("The equivalent decimal number for hexadecimal " + "\"" + hexStr + "\"" + "is: " + decimal);
        }
    }

    public static int octalToDecimal(String octalStr) {
        int decimal = 0;
        int power = 1;

        for (int i = octalStr.length() - 1; i >= 0; --i) {
            char octalChar = octalStr.charAt(i);
            int value;

            if (octalChar >= '0' && octalChar <= '7') {
                value = octalChar - '0';
            } else {
                return -1;
            }
            decimal += value * power;
            power *= 8;

        }
        return decimal;
    }

    public static void testOctalToDecimal() {
        String octalStr;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an Octal string: ");

        octalStr = in.next();

        System.out.print("The equivalent decimal number " + "\"" + octalStr + "\" 1" + "is: " + octalToDecimal(octalStr));
    }

    public static int radixNToDecimal(String radixNStr, int base) {
        if (base < 2 || base > 16) {
            return -1;
        }
        int decimal = 0;
        int power = 1;
        for (int i = radixNStr.length() - 1; i >= 0; --i) {
            char digit = radixNStr.charAt(i);
            int value;

            if (digit >= '0' && digit <= '9') {
                value = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                value = digit - 'A' + 10;
            } else if (digit >= 'a' && digit <= 'f') {
                value = digit - 'a' + 10;
            } else {
                return -1;
            }
            if (value >= base) {
                return -1;
            }
            decimal += value * power;
            power *= base;
        }
        return decimal;
    }

    public static void testRadixNtoDecimal() {
        String radixNStr;
        int base;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the radix: ");
        base = in.nextInt();

        System.out.print("Enter the string: ");
        radixNStr = in.next();

        int decimal = radixNToDecimal(radixNStr, base);

        if (decimal == -1) {
            System.out.print("Invalid");
        } else {
            System.out.print("The equivalent decimal for number" + "\"" + radixNStr + "\" is: " + decimal);
        }

    }


    public static void main(String[] args) {
//        testReverseString();
//        testCountVowelsDigits();
//        testPhoneKeyPad();
//        testCipherCaesarCode();
//        testDecipherCaesarCode();
//        testIsHexString();
//        testBinaryToDecimal();
//        testHexadecimalToDecimal();
//        testOctalToDecimal();
        testRadixNtoDecimal();
    }
}
