package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_TestBinarySearch;

public class InsertionSort implements Sorter {
    public InsertionSort() {
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

        for (int i = 1; i < n; i++) {
            double key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;

            }
            array[j + 1] = key;
        }

    }

    private void sortDescending(double[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            double key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;

            }
            array[j + 1] = key;
        }

    }
}
