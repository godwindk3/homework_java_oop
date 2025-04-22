package hus.oop.test_exam_training_2022.sortstrategy;

public class SelectionSort implements ISort {
    @Override
    public int sort(int[] data) {
        int swapCount = 0;
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Tìm phần tử nhỏ nhất
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi nếu tìm thấy phần tử nhỏ hơn
            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
                swapCount++;
            }
        }

        return swapCount;
    }
}
