package hus.oop.final_2022_2023_matrix_integration_studentmanager.matrix;

public class SquareMatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        // Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10]
        int size = (int) (Math.random() * 6) + 5; // Random size between 5 and 10

        SquareMatrix matrix1 = new SquareMatrix(size);
        SquareMatrix matrix2 = new SquareMatrix(size);

        // In ra 2 ma trận và 2 ma trận chuyển vị tương ứng
        System.out.println("Ma trận 1:");
        System.out.println(matrix1);

        System.out.println("Ma trận chuyển vị của ma trận 1:");
        System.out.println(matrix1.transpose());

        System.out.println("Ma trận 2:");
        System.out.println(matrix2);

        System.out.println("Ma trận chuyển vị của ma trận 2:");
        System.out.println(matrix2.transpose());

        // In ra các đường chéo chính và đường chéo phụ của 2 ma trận
        System.out.println("Đường chéo chính của ma trận 1:");
        printArray(matrix1.principalDiagonal());

        System.out.println("Đường chéo phụ của ma trận 1:");
        printArray(matrix1.secondaryDiagonal());

        System.out.println("Đường chéo chính của ma trận 2:");
        printArray(matrix2.principalDiagonal());

        System.out.println("Đường chéo phụ của ma trận 2:");
        printArray(matrix2.secondaryDiagonal());

        // In ra ma trận là ma trận tổng của 2 ma trận
        System.out.println("Ma trận tổng của 2 ma trận:");
        System.out.println(matrix1.add(matrix2));

        // In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2
        System.out.println("Ma trận hiệu của ma trận 1 trừ ma trận 2:");
        System.out.println(matrix1.minus(matrix2));

        // In ra ma trận là ma trận tích của 2 ma trận
        System.out.println("Ma trận tích của 2 ma trận:");
        System.out.println(matrix1.multiply(matrix2));

        // In ra các số nguyên tố có trong 2 ma trận
        System.out.println("Các số nguyên tố trong ma trận 1:");
        printArray(matrix1.primes());

        System.out.println("Các số nguyên tố trong ma trận 2:");
        printArray(matrix2.primes());

        // Bonus: Ma trận được sắp xếp
        System.out.println("Ma trận 1 sau khi sắp xếp các phần tử:");
        System.out.println(matrix1.getSortedMatrix());
    }
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
