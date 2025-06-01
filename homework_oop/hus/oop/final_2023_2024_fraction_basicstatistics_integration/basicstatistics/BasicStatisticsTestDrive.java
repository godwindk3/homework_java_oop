package hus.oop.final_2023_2024_fraction_basicstatistics_integration.basicstatistics;

import java.util.Random;

public class BasicStatisticsTestDrive {
    public static void main(String[] args) {
        /*
           - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_BasicStatistics>.txt (Ví dụ, NguyenVanA_123456_BasicStatistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_BasicStatistics>.zip (Ví dụ, NguyenVanA_123456_BasicStatistics.zip),
             nộp lên classroom.
         */
        System.out.println("=== BASIC STATISTICS TEST DRIVE ===\n");

        System.out.println("Testing MyArrayList:");
        testMyArrayList();

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("Testing MyLinkedList:");
        testMyLinkedList();

    }

    public static void testMyArrayList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một danh sách kiểu MyArrayList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra các dữ liệu và các đại lượng thống kê.
         */
        Random random = new Random();
        int length = random.nextInt(21) + 30; // [30, 50]

        MyArrayList arrayList = new MyArrayList();

        System.out.println("Generating " + length + " random numbers for MyArrayList:");
        for (int i = 0; i < length; i++) {
            double value = random.nextDouble() * 19 + 1; // [1, 20]
            arrayList.append(value);
        }

        System.out.println("Data: " + arrayList.toString());
        System.out.println("Size: " + arrayList.size());

        BasicStatistic stats = new BasicStatistic(arrayList);

        System.out.println("\nStatistics:");
        System.out.printf("Max: %.4f\n", stats.max());
        System.out.printf("Min: %.4f\n", stats.min());
        System.out.printf("Mean: %.4f\n", stats.mean());
        System.out.printf("Variance: %.4f\n", stats.variance());
    }

    public static void testMyLinkedList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo ra một danh sách kiểu MyLinkedList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */

        Random random = new Random();
        int length = random.nextInt(21) + 30; // [30, 50]

        MyLinkedList linkedList = new MyLinkedList();

        System.out.println("Generating " + length + " random numbers for MyLinkedList:");
        for (int i = 0; i < length; i++) {
            double value = random.nextDouble() * 19 + 1; // [1, 20]
            linkedList.append(value);
        }

        System.out.println("Data: " + linkedList.toString());
        System.out.println("Size: " + linkedList.size());

        BasicStatistic stats = new BasicStatistic(linkedList);

        System.out.println("\nStatistics:");
        System.out.printf("Max: %.4f\n", stats.max());
        System.out.printf("Min: %.4f\n", stats.min());
        System.out.printf("Mean: %.4f\n", stats.mean());
        System.out.printf("Variance: %.4f\n", stats.variance());
    }
}

