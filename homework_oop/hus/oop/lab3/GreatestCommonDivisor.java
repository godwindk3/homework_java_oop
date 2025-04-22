package hus.oop.lab3;

public class GreatestCommonDivisor {
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18));
        System.out.println(gcd(101, 103));
        System.out.println(gcd(56, 98));
    }
}
