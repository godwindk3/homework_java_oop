package hus.oop.lab1;

public class SumAverageRunningIntWhileDo {
    public static void main(String[] args) {
        final int LOWERBOUND = 1;
        final int UPPERBOUND = 100;
        double average;
        int sum = 0;
        int number = LOWERBOUND;
        while (number <= UPPERBOUND) {
            sum += number;
            ++number;
        }
        average = sum / 100.0;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
