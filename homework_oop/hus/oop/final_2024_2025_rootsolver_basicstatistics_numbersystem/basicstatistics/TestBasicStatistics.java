package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.basicstatistics;

import java.util.Random;

public class TestBasicStatistics {
    public static void main(String[] args) {
        /*
           - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_BasicStatistics>.txt (Ví dụ, NguyenVanA_123456_BasicStatistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_BasicStatistics>.zip (Ví dụ, NguyenVanA_123456_BasicStatistics.zip),
             nộp lên classroom.
         */
        System.out.println("=== Test MyArrayList ===");
        testMyArrayList();

        System.out.println("\n=== Test MyLinkedList ===");
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một danh sách kiểu MyArrayList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra terminal tập dữ liệu và các đại lượng thống kê.
         */
        Random random = new Random();
        int length = 30 + random.nextInt(21); // [30, 50]

        MyArrayList arrayList = new MyArrayList();

        // Thêm các phần tử ngẫu nhiên vào danh sách
        for (int i = 0; i < length; i++) {
            double value = 1 + random.nextDouble() * 19; // [1, 20]
            arrayList.append(value);
        }

        // Tính toán thống kê
        BasicStatistic stats = new BasicStatistic(arrayList);

        System.out.println("MyArrayList data (length = " + length + "):");
        System.out.println(arrayList.toString());
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
    }

    public static void testMyLinkedList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo ra một danh sách kiểu MyLinkedList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra terminal tập dữ liệu và các đại lượng thống kê.
         */
        Random random = new Random();
        int length = 30 + random.nextInt(21); // [30, 50]

        MyLinkedList linkedList = new MyLinkedList();

        // Thêm các phần tử ngẫu nhiên vào danh sách
        for (int i = 0; i < length; i++) {
            double value = 1 + random.nextDouble() * 19; // [1, 20]
            linkedList.append(value);
        }

        // Tính toán thống kê
        BasicStatistic stats = new BasicStatistic(linkedList);

        System.out.println("MyLinkedList data (length = " + length + "):");
        System.out.println(linkedList.toString());
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Mean: " + stats.mean());
        System.out.println("Variance: " + stats.variance());
    }
}
