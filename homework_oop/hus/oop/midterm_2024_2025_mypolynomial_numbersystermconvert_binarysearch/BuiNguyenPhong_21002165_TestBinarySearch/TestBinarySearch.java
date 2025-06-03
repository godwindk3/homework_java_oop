package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_TestBinarySearch;

public class TestBinarySearch {
    public static void main(String[] args) {
        double[] array = {5.0, 2.0, 8.0, 1.0, 9.0};

        // Test BubbleSort
        double[] bubbleArray = array.clone();
        Sorter bubble = new BubbleSort();
        bubble.sort(bubbleArray, true);
        System.out.println("BubbleSort Ascending: " + java.util.Arrays.toString(bubbleArray));

        // Test InsertionSort
        double[] insertionArray = array.clone();
        Sorter insertion = new InsertionSort();
        insertion.sort(insertionArray, false);
        System.out.println("InsertionSort Descending: " + java.util.Arrays.toString(insertionArray));

        // Test SelectionSort
        double[] selectionArray = array.clone();
        Sorter selection = new SelectionSort();
        selection.sort(selectionArray, true);
        System.out.println("SelectionSort Ascending: " + java.util.Arrays.toString(selectionArray));
    }
}
