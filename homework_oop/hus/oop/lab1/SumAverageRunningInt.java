package hus.oop.lab1;

public class SumAverageRunningInt {
    public static void main(String[] args) {
        int sum = 0;
        double average;
        final int LOWERBOUND = 1;
        final int UPPERBOUND = 100;

        for (int number = LOWERBOUND; number <= UPPERBOUND; ++number) {
            sum += number;
        }
        average = sum / 100.0;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
