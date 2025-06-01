package hus.oop.final_2023_2024_fraction_basicstatistics_integration.fraction;

import java.util.Random;

public class FractionTestDrive {
    public static void main(String[] args) {
        /*
        TODO:
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu DataSet, được gọi là dataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.

         5. - Chạy chương trình và lưu kết quả chạy chương trình và file text được đặt tên
              là <TenSinhVien_MaSinhVien_Fraction>.txt (Ví dụ, NguyenVanA_123456_Fraction.txt).
            - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
              <TenSinhVien_MaSinhVien_Fraction>.zip (Ví dụ, NguyenVanA_123456_Fraction.zip),
              nộp lên classroom.
         */
        System.out.println("=== FRACTION TEST DRIVE ===\n");

        // 1. Sinh ngẫu nhiên số lượng phân số trong đoạn [30, 50]
        Random random = new Random();
        int numbers = random.nextInt(21) + 30; // [30, 50]

        System.out.println("Generating " + numbers + " random fractions...\n");

        // 2. Tạo DataSet và sinh ngẫu nhiên các phân số
        DataSet dataSet = new DataSet();

        for (int i = 0; i < numbers; i++) {
            int numerator = random.nextInt(100) + 1;   // [1, 100]
            int denominator = random.nextInt(100) + 1; // [1, 100]
            Fraction fraction = new Fraction(numerator, denominator);
            dataSet.append(fraction);
        }

        System.out.println("Original dataset:");
        System.out.println(dataSet.toString());
        System.out.println("Size: " + dataSet.getLength() + "\n");

        // 3. Sắp xếp và in ra theo các tiêu chí
        System.out.println("=".repeat(60));
        System.out.println("SORTING ORIGINAL FRACTIONS");
        System.out.println("=".repeat(60));

        // Sắp xếp tăng dần
        System.out.println("\n1. Fractions sorted in INCREASING order:");
        System.out.println("   (If equal values, sorted by denominator increasing)");
        Fraction[] increasingOrder = dataSet.sortIncreasing();
        DataSet.printFractions(increasingOrder);

        // Sắp xếp giảm dần
        System.out.println("\n2. Fractions sorted in DECREASING order:");
        System.out.println("   (If equal values, sorted by denominator decreasing)");
        Fraction[] decreasingOrder = dataSet.sortDecreasing();
        DataSet.printFractions(decreasingOrder);

        // 4. Xử lý phân số tối giản
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SIMPLIFIED FRACTIONS");
        System.out.println("=".repeat(60));

        // Tạo tập dữ liệu phân số tối giản
        DataSet simplifiedDataSet = dataSet.toSimplify();

        // In ra phân số tối giản theo thứ tự gốc
        System.out.println("\n3. Simplified fractions (original order):");
        System.out.println(simplifiedDataSet.toString());

        // In ra phân số tối giản theo thứ tự tăng dần
        System.out.println("\n4. Simplified fractions sorted in INCREASING order:");
        Fraction[] simplifiedIncreasing = simplifiedDataSet.sortIncreasing();
        DataSet.printFractions(simplifiedIncreasing);

        // In ra phân số tối giản theo thứ tự giảm dần
        System.out.println("\n5. Simplified fractions sorted in DECREASING order:");
        Fraction[] simplifiedDecreasing = simplifiedDataSet.sortDecreasing();
        DataSet.printFractions(simplifiedDecreasing);

        // Thống kê bổ sung
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ADDITIONAL STATISTICS");
        System.out.println("=".repeat(60));

        System.out.println("\nTotal number of fractions: " + dataSet.getLength());

        // Tìm phân số có giá trị lớn nhất và nhỏ nhất
        Fraction[] originalData = dataSet.getData();
        if (originalData.length > 0) {
            Fraction max = originalData[0];
            Fraction min = originalData[0];

            for (int i = 1; i < originalData.length; i++) {
                if (originalData[i].compareTo(max) > 0) {
                    max = originalData[i];
                }
                if (originalData[i].compareTo(min) < 0) {
                    min = originalData[i];
                }
            }

            System.out.printf("Largest fraction: %s = %.6f\n", max.toString(), max.doubleValue());
            System.out.printf("Smallest fraction: %s = %.6f\n", min.toString(), min.doubleValue());
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("TEST COMPLETED SUCCESSFULLY!");
        System.out.println("=".repeat(60));

    }
}
