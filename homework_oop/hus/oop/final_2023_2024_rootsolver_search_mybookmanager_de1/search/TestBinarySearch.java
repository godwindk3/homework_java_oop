package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class TestBinarySearch {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
          mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        try {
            PrintStream out = new PrintStream(new File("output.txt"));
            System.setOut(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int n = 20 + random.nextInt(11); // Sinh kích thước ngẫu nhiên từ 20 đến 30
        double[] originalData = new double[n];
        for (int i = 0; i < n; i++) {
            originalData[i] = random.nextDouble() * 10; // Sinh số ngẫu nhiên từ 0 đến 10
        }

        BinarySearch binarySearch = BinarySearch.getInstance();

        Sorter[] sorters = {new BubbleSort(), new InsertionSort(), new SelectionSort()};
        String[] sorterNames = {"Bubble Sort", "Insertion Sort", "Selection Sort"};

        for (int i = 0; i < sorters.length; i++) {
            double[] data = Arrays.copyOf(originalData, originalData.length);
            binarySearch.setSorter(sorters[i]);
            System.out.println("Using " + sorterNames[i] + " Algorithm:");
            System.out.println("Before sorting: " + Arrays.toString(data));
            double value = 5.0;
            int result = binarySearch.search(data, value);
            System.out.println("After sorting: " + Arrays.toString(data));
            System.out.println("Binary search giá trị " + value + ": " + result);
            System.out.println();
        }
    }
}
