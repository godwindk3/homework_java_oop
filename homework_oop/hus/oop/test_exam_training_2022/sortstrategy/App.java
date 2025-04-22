package hus.oop.test_exam_training_2022.sortstrategy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // Tạo mảng số tự nhiên ngẫu nhiên
        int[] data = generateRandomArray(5, 1, 10); // Mảng 5 phần tử, giá trị từ 1 đến 10
        StringBuilder output = new StringBuilder();

        // Tạo instance của SortStrategy
        SortStrategy strategy = SortStrategy.getInstance();

        // Danh sách các thuật toán sắp xếp
        ISort[] sorters = {new BubbleSort(), new SelectionSort(), new InsertionSort()};
        String[] sorterNames = {"Bubble Sort", "Selection Sort", "Insertion Sort"};

        // Thực hiện từng thuật toán sắp xếp
        for (int i = 0; i < sorters.length; i++) {
            // Sao chép mảng gốc để không ảnh hưởng giữa các thuật toán
            int[] dataCopy = data.clone();

            // In thông tin thuật toán
            output.append("Using ").append(sorterNames[i]).append(" Algorithm:\n");
            output.append("Before sorting: ").append(arrayToString(dataCopy)).append("\n");

            // Thiết lập thuật toán và sắp xếp
            strategy.setSortee(sorters[i]);
            int swapCount = strategy.sort(dataCopy);

            // In kết quả
            output.append("After sorting: ").append(arrayToString(dataCopy)).append("\n");
            output.append("Number of swap: ").append(swapCount).append("\n\n");
        }

        // Lưu kết quả vào file
        saveToFile(output.toString(), "SortStrategy21002165.txt");
    }

    // Tạo mảng ngẫu nhiên
    private static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    // Chuyển mảng thành chuỗi dạng [1 2 3]
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Lưu kết quả vào file
    private static void saveToFile(String content, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
