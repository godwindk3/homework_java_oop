package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_TestBinarySearch;

public class BubbleSort implements Sorter {

    public BubbleSort() {
    }

    @Override
    public void sort(double[] array, boolean isAscending) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (isAscending) {
            sortAscending(array);
        } else {
            sortDescending(array);
        }
    }

    private void sortAscending(double[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Hoán đổi
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void sortDescending(double[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    // Hoán đổi
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

}
