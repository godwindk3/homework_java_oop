package hus.oop.final_2024_2025_vector_fraction_statistics_de1.fraction;

import java.util.Random;

public class TestFraction {
    private MyDataSet myDataSet;

    public TestFraction(MyDataSet myDataSet) {
        this.myDataSet = myDataSet;
    }

    public static void main(String[] args) {
        TestFraction testArray = new TestFraction(new MyArrayDataSet());
        testArray.testMyArrayDataSet();

        TestFraction testList = new TestFraction(new MyListDataSet());
        testList.testMyListDataSet();

        /* TODO:
         - Viết code cho các hàm test.
         - Chạy chương trình và lưu kết quả chạy chương trình và file text được đặt tên
           là <TenSinhVien_MaSinhVien_MyFractions>.txt (Ví dụ, NguyenVanA_123456_MyFractions.txt).
         - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
           <TenSinhVien_MaSinhVien_MyFractions>.zip (Ví dụ, NguyenVanA_123456_MyFractions.zip),
           nộp lên classroom.
         */
    }

    public void testMyArrayDataSet() {
        Random rand = new Random();
        int numbers = 30 + rand.nextInt(21); // Sinh ngẫu nhiên từ 30 đến 50
        MyArrayDataSet dataSet = new MyArrayDataSet();
        for (int i = 0; i < numbers; i++) {
            int numerator = 1 + rand.nextInt(100);
            int denominator = 1 + rand.nextInt(100);
            dataSet.append(new MyFraction(numerator, denominator));
        }

        System.out.println("Original DataSet:");
        dataSet.print();

        MyArrayDataSet sortedIncreasing = dataSet.sortIncreasing();
        System.out.println("Sorted Increasing:");
        sortedIncreasing.print();

        MyArrayDataSet sortedDecreasing = dataSet.sortDecreasing();
        System.out.println("Sorted Decreasing:");
        sortedDecreasing.print();

        MyArrayDataSet simplified = dataSet.toSimplify();
        System.out.println("Simplified DataSet:");
        simplified.print();

        MyArrayDataSet simplifiedIncreasing = simplified.sortIncreasing();
        System.out.println("Simplified Sorted Increasing:");
        simplifiedIncreasing.print();

        MyArrayDataSet simplifiedDecreasing = simplified.sortDecreasing();
        System.out.println("Simplified Sorted Decreasing:");
        simplifiedDecreasing.print();
    }

    public void testMyListDataSet() {
        Random rand = new Random();
        int numbers = 30 + rand.nextInt(21); // Sinh ngẫu nhiên từ 30 đến 50
        MyListDataSet dataSet = new MyListDataSet();
        for (int i = 0; i < numbers; i++) {
            int numerator = 1 + rand.nextInt(100);
            int denominator = 1 + rand.nextInt(100);
            dataSet.append(new MyFraction(numerator, denominator));
        }

        System.out.println("Original DataSet:");
        dataSet.print();

        MyListDataSet sortedIncreasing = dataSet.sortIncreasing();
        System.out.println("Sorted Increasing:");
        sortedIncreasing.print();

        MyListDataSet sortedDecreasing = dataSet.sortDecreasing();
        System.out.println("Sorted Decreasing:");
        sortedDecreasing.print();

        MyListDataSet simplified = dataSet.toSimplify();
        System.out.println("Simplified DataSet:");
        simplified.print();

        MyListDataSet simplifiedIncreasing = simplified.sortIncreasing();
        System.out.println("Simplified Sorted Increasing:");
        simplifiedIncreasing.print();

        MyListDataSet simplifiedDecreasing = simplified.sortDecreasing();
        System.out.println("Simplified Sorted Decreasing:");
        simplifiedDecreasing.print();
    }
}