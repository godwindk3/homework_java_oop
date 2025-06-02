package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.matrix;

public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size, size);
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     *
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        int size = getSize();
        double[] diag = new double[size];
        for (int i = 0; i < size; i++)
            diag[i] = get(i, i);
        return diag;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     *
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        int size = getSize();
        double[] diag = new double[size];
        for (int i = 0; i < size; i++)
            diag[i] = get(i, size - 1 - i);
        return diag;
    }

    private int getSize() {
        return (int) Math.sqrt(super.toString().split("\n").length);
    }
}
