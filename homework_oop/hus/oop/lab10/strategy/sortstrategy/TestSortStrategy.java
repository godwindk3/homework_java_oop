package hus.oop.lab10.strategy.sortstrategy;

import java.util.Arrays;

public class TestSortStrategy {
    public static void main(String[] args) {

        // initial different sort algorithm
        ISort bubbleSort = new BubbleSort();
        ISort selectionSort = new SelectionSort();
        ISort insertionSort = new InsertionSort();

        SortStrategy strategy = SortStrategy.getInstance();
        // Initial int array
        int[] array = {1, 4, 5, 6, 7, 2, 9};
        int[] temp1 = array.clone();
        int[] temp2 = array.clone();
        int[] temp3 = array.clone();

        // Bubble sort
        strategy.setSortee(bubbleSort);
        System.out.println("Bubble sort: ");
        strategy.sort(temp1);
        System.out.println(Arrays.toString(temp1));

        // Selection sort
        strategy.setSortee(selectionSort);
        System.out.println("Selection sort: ");
        strategy.sort(temp2);
        System.out.println(Arrays.toString(temp2));

        // Insertion sort
        strategy.setSortee(insertionSort);
        System.out.println("Insertion sort: ");
        strategy.sort(temp3);
        System.out.println(Arrays.toString(temp3));

    }
}
