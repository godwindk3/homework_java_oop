package hus.oop.lab1;

public class TwoSums {
    public static void main(String[] args) {
        int sumOdd = 0;
        int sumEven = 0;
        int absDiff;
        for (int number = 1; number <= 100; number++) {
            if (number % 2 != 0) {
                sumOdd += number;
            } else {
                sumEven += number;
            }
        }

        if (sumOdd > sumEven) {
            absDiff = sumOdd - sumEven;
        } else {
            absDiff = sumEven - sumOdd;
        }
        System.out.println("Sum Odd = " + sumOdd);
        System.out.println("Sum Even = " + sumEven);
        System.out.println("Abs Diff = " + absDiff);
    }
}
