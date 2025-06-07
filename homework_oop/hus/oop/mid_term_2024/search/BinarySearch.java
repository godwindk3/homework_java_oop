// File: hus/oop/search/BinarySearch.java
package hus.oop.mid_term_2024.search;

public class BinarySearch implements Search {
    private static BinarySearch instance;
    private Sorter sorter;

    private BinarySearch() {
        // private constructor
    }

    /**
     * Tạo đối tượng BinarySearch (singleton).
     * @return instance duy nhất của BinarySearch
     */
    public static BinarySearch getInstance() {
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private void sort(double[] data) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter chưa được thiết lập.");
        }
        // mặc định sắp xếp tăng dần
        sorter.sort(data, true);
    }

    private int binarySearch(double[] data, double value) {
        int low = 0, high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (data[mid] < value) {
                low = mid + 1;
            } else if (data[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
