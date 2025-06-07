// File: hus/oop/search/InsertionSort.java
package hus.oop.mid_term_2024.search;

public class InsertionSort implements Sorter {
    /**
     * Phương thức sắp xếp sử dụng Insertion sort.
     * @param data mảng cần sắp xếp
     * @param order true: tăng dần, false: giảm dần
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    private void sortAscending(double[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            double key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    private void sortDescending(double[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            double key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] < key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }
}
