package hus.oop.test_exam_training_2022.sortstrategy;

public class InsertionSort implements ISort {
    @Override
    public int sort(int[] data) {
        int swapCount = 0;
        int n = data.length;

        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;

            // Dịch chuyển các phần tử lớn hơn key
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
                swapCount++; // Đếm mỗi lần gán như một hoán đổi
            }
            data[j + 1] = key;
        }

        return swapCount;
    }
}
