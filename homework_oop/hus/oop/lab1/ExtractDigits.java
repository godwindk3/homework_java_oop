package hus.oop.lab1;

public class ExtractDigits {
    public static void main(String[] args) {
        int n = 15423;
        int digit;
        while (n > 0) {
            digit = n % 10;
            System.out.println("Digit: " + digit);
            n = n / 10;
        }
    }
}
