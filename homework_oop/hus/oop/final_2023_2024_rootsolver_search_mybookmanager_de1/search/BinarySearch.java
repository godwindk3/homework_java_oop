package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.search;

public class BinarySearch implements Search {
    private static BinarySearch instance;
    private Sorter sorter;

    private BinarySearch() {
        /* TODO */
    }

    /**
     * Tạo đối tượng BinarySearch.
     *
     * @return
     */
    public static BinarySearch getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        /* TODO */
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        /* TODO */
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == value) {
                return mid;
            } else if (data[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private void sort(double[] data) {
        /* TODO */
        if (sorter != null) {
            sorter.sort(data, true); // Sắp xếp tăng dần cho tìm kiếm nhị phân
        } else {
            throw new IllegalStateException("Sorter chưa được thiết lập");
        }
    }
}
