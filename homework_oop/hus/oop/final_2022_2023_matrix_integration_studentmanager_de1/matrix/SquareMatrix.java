package hus.oop.final_2022_2023_matrix_integration_studentmanager_de1.matrix;

public class SquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     *
     * @param size
     */
    public SquareMatrix(int size) {
        initRandom(size);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong khoảng [1, 100]
     *
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = (int) (Math.random() * 100) + 1;
            }
        }
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     *
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        /* TODO */
        int size = data.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i][i];
        }
        return result;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     *
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int size = data.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i][size - 1 - i];
        }
        return result;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     *
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        /* TODO */
        int size = data.length;
        int maxSize = size * size;
        int[] temp = new int[maxSize];
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPrime(data[i][j])) {
                    temp[count++] = data[i][j];
                }
            }
        }

        int[] result = new int[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     *
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public SquareMatrix getSortedMatrix() {
        /* TODO */
        int size = data.length;
        SquareMatrix result = new SquareMatrix(size);

        // Convert 2D array to 1D for sorting
        int[] temp = new int[size * size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[index++] = data[i][j];
            }
        }

        // Sort the 1D array
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = 0; j < temp.length - i - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    int t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                }
            }
        }

        // Convert back to 2D
        index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = temp[index++];
            }
        }

        return result;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     *
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
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
    public void set(int row, int col, int value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public SquareMatrix add(SquareMatrix that) {
        /* TODO */
        int size = data.length;
        SquareMatrix result = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] + that.data[i][j];
            }
        }

        return result;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public SquareMatrix minus(SquareMatrix that) {
        /* TODO */
        int size = data.length;
        SquareMatrix result = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] - that.data[i][j];
            }
        }

        return result;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public SquareMatrix multiply(SquareMatrix that) {
        /* TODO */
        int size = data.length;
        SquareMatrix result = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result.data[i][j] += this.data[i][k] * that.data[k][j];
                }
            }
        }

        return result;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public SquareMatrix scaled(int value) {
        /* TODO */
        int size = data.length;
        SquareMatrix result = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] * value;
            }
        }

        return result;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     *
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public SquareMatrix transpose() {
        /* TODO */
        int size = data.length;
        SquareMatrix result = new SquareMatrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[j][i];
            }
        }

        return result;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        int size = data.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(data[i][j]).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
