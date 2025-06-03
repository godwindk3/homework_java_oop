package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_TestBinarySearch;

public class BinarySearch implements Search {
    private Sorter sorter;

    public BinarySearch() {
    }

    public BinarySearch(Sorter sorter) {
        if (sorter == null) {
            throw new IllegalArgumentException("Sorter cannot be null");
        }
        this.sorter = sorter;
    }

    private int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Tránh tràn số
            if (Math.abs(array[mid] - value) < 1e-10) { // So sánh số thực
                return mid;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public int search(double[] array, double value) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (sorter == null) {
            throw new IllegalStateException("Sorter not set");
        }

        double[] sortedArray = array.clone();
        sort(sortedArray);

        return binarySearch(sortedArray, value);
    }

    public void setSorter(Sorter sorter) {
        if (sorter == null) {
            throw new IllegalArgumentException("Sorter cannot be null");
        }
        this.sorter = sorter;
    }

    private void sort(double[] array) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter not set");
        }
        sorter.sort(array, true); // Sắp xếp tăng dần
    }

}
