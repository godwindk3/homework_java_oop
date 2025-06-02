package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.matrix;

import java.util.Random;

public class MatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Yêu cầu

        Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [5, 10], lưu vào biến n.
        Tạo ra 2 ma trận vuông có cùng kích thước n. Trong đó các phần tử của ma trận được khởi tạo bằng cách sinh ngẫu nhiên
        có giá trị nằm trong đoạn [1, 10].

        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text theo tên <TenSinhVien_MaSinhVien_Matrix.txt>
         (Ví dụ, NguyenVanA_123456_Matrix.txt).
         Nén các file source code và file text kết quả vào file <TenSinhVien_MaSinhVien_Matrix.zip>, nộp lên classroom.
         */
        Random rand = new Random();
        int n = rand.nextInt(6) + 5;

        SquareMatrix m1 = new SquareMatrix(n);
        SquareMatrix m2 = new SquareMatrix(n);

        System.out.println("Matrix 1:");
        System.out.println(m1);
        System.out.println("Transpose Matrix 1:");
        System.out.println(m1.transpose());

        System.out.println("Matrix 2:");
        System.out.println(m2);
        System.out.println("Transpose Matrix 2:");
        System.out.println(m2.transpose());

        System.out.println("Principal Diagonal Matrix 1:");
        for (double d : m1.principalDiagonal()) System.out.print(d + " ");
        System.out.println("\nSecondary Diagonal Matrix 1:");
        for (double d : m1.secondaryDiagonal()) System.out.print(d + " ");

        System.out.println("\nPrincipal Diagonal Matrix 2:");
        for (double d : m2.principalDiagonal()) System.out.print(d + " ");
        System.out.println("\nSecondary Diagonal Matrix 2:");
        for (double d : m2.secondaryDiagonal()) System.out.print(d + " ");

        System.out.println("\nMatrix Add:");
        System.out.println(m1.add(m2));

        System.out.println("Matrix Subtract:");
        System.out.println(m1.minus(m2));

        System.out.println("Matrix Multiply:");
        System.out.println(m1.multiply(m2));

        System.out.println("Gaussian Elimination Matrix 1:");
        System.out.println(m1.gaussianElimination());

        System.out.println("Gaussian Elimination Matrix 2:");
        System.out.println(m2.gaussianElimination());
    }
}
