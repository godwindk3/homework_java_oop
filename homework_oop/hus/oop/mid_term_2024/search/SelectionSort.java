// File: hus/oop/search/SelectionSort.java
package hus.oop.mid_term_2024.search;

public class SelectionSort implements Sorter {
    /**
     * Phương thức sắp xếp sử dụng Selection sort.
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
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIdx]) {
                    minIdx = j;
                }
            }
            double tmp = data[i];
            data[i] = data[minIdx];
            data[minIdx] = tmp;
        }
    }

    private void sortDescending(double[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] > data[maxIdx]) {
                    maxIdx = j;
                }
            }
            double tmp = data[i];
            data[i] = data[maxIdx];
            data[maxIdx] = tmp;
        }
    }
}
