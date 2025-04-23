package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_TestBinarySearch;

public class SelectionSort implements Sorter {
    public SelectionSort() {
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
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                double temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    private void sortDescending(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                double temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }

    }
}
