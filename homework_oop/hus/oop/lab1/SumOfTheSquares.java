package hus.oop.lab1;

public class SumOfTheSquares {
    public static void main(String[] args) {
        int sum = 0;
        final int LOWERBOUND = 1;
        final int UPPERBOUND = 100;
        int temp;
        for (int number = LOWERBOUND; number <= UPPERBOUND; ++number) {
            temp = number * number;
            sum += temp;
        }
        System.out.println("Sum of the squares = " + sum);
    }
}
