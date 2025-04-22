package hus.oop.lab1;

public class SumAverageRunningIntModify {
    public static void main(String[] args) {
        int sum = 0;
        double average;
        final int LOWERBOUND = 111;
        final int UPPERBOUND = 8899;
        int count = 0;
        for (int number = LOWERBOUND; number <= UPPERBOUND; ++number) {
            sum += number;
            ++count;
        }
        System.out.println(count);
        average = sum / (double) count;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
