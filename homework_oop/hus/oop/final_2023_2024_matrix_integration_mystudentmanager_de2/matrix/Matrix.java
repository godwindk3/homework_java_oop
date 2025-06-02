package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private double[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        /* TODO */
        initRandom(rows, columns);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        /* TODO */
        Random rand = new Random();
        data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = rand.nextInt(10) + 1; // [1, 10]
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     *
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     *
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     *
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        double[] flat = new double[rows * cols];
        int index = 0;
        for (double[] row : data)
            for (double val : row)
                flat[index++] = val;

        Arrays.sort(flat);

        Matrix sortedMatrix = new Matrix(rows, cols);
        index = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                sortedMatrix.set(i, j, flat[index++]);

        return sortedMatrix;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.set(i, j, this.get(i, j) + that.get(i, j));
        return result;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.set(i, j, this.get(i, j) - that.get(i, j));
        return result;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận nhân của hai ma trận.
     */
    public Matrix multiply(Matrix that) {
        /* TODO */
        int rows = data.length;
        int cols = that.data[0].length;
        int common = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                double sum = 0;
                for (int k = 0; k < common; k++)
                    sum += this.get(i, k) * that.get(k, j);
                result.set(i, j, sum);
            }
        return result;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.set(i, j, this.get(i, j) * value);
        return result;
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        /* TODO */
        Matrix result = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                result.set(i, j, (i == rowIndex) ? this.get(i, j) * value : this.get(i, j));
        return result;
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        /* TODO */
        Matrix result = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                result.set(i, j, (j == columnIndex) ? this.get(i, j) * value : this.get(i, j));
        return result;
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     *
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        /* TODO */
        double[] temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     *
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            double temp = data[i][firstIndex];
            data[i][firstIndex] = data[i][secondIndex];
            data[i][secondIndex] = temp;
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     *
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int j = 0; j < data[0].length; j++)
            data[destIndex][j] += value * data[sourceIndex][j];
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     *
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int i = 0; i < data.length; i++)
            data[i][destIndex] += value * data[i][sourceIndex];
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     *
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.set(j, i, this.get(i, j));
        return result;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     *
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);

        // copy data
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.set(i, j, this.get(i, j));

        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (lead >= cols) break;
            int i = r;
            while (result.get(i, lead) == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (lead == cols) return result;
                }
            }

            result.swapRows(i, r);

            double lv = result.get(r, lead);
            for (int j = 0; j < cols; j++)
                result.set(r, j, result.get(r, j) / lv);

            for (int i2 = r + 1; i2 < rows; i2++) {
                double lv2 = result.get(i2, lead);
                for (int j = 0; j < cols; j++)
                    result.set(i2, j, result.get(i2, j) - lv2 * result.get(r, j));
            }
            lead++;
        }
        return result;
    }

    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     *
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            for (double val : row) {
                sb.append(String.format("%.2f ", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
