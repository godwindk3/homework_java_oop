package hus.oop.final_2022_2023_matrix_integration_studentmanager_de1.integration;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     *
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            return 0;
        }
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        return Arrays.copyOf(coefficents, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size == coefficents.length) {
            enlarge();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0) {
            throw new IllegalArgumentException("Index phải >= 0");
        }
        if (index > size) {
            // nếu index > size, mở rộng để đặt hệ số và điền 0 ở giữa
            while (index >= coefficents.length) {
                enlarge();
            }
            for (int i = size; i < index; i++) {
                coefficents[i] = 0;
            }
            coefficents[index] = coefficient;
            size = index + 1;
            return this;
        }
        // index <= size
        if (size == coefficents.length) {
            enlarge();
        }
        // đẩy phần từ index..size-1 sang phải 1 ô
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i - 1];
        }
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0) {
            throw new IllegalArgumentException("Index phải >= 0");
        }
        if (index >= size) {
            // mở rộng mảng để đặt hệ số
            while (index >= coefficents.length) {
                enlarge();
            }
            for (int i = size; i < index; i++) {
                coefficents[i] = 0;
            }
            coefficents[index] = coefficient;
            size = index + 1;
        } else {
            coefficents[index] = coefficient;
        }
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     *
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        if (size == 0) {
            return 0;
        }
        double result = coefficents[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] derivCoeffs = differentiate();
        ArrayPolynomial derivPoly = new ArrayPolynomial();
        for (double c : derivCoeffs) {
            derivPoly.append(c);
        }
        return derivPoly;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.size, another.size);
        double[] result = new double[maxSize];
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.size) ? this.coefficents[i] : 0;
            double b = (i < another.size) ? another.coefficents[i] : 0;
            result[i] = a + b;
        }
        // cập nhật về this
        this.size = maxSize;
        if (coefficents.length < maxSize) {
            coefficents = new double[maxSize];
        }
        System.arraycopy(result, 0, this.coefficents, 0, maxSize);
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.size, another.size);
        double[] result = new double[maxSize];
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.size) ? this.coefficents[i] : 0;
            double b = (i < another.size) ? another.coefficents[i] : 0;
            result[i] = a - b;
        }
        // cập nhật về this
        this.size = maxSize;
        if (coefficents.length < maxSize) {
            coefficents = new double[maxSize];
        }
        System.arraycopy(result, 0, this.coefficents, 0, maxSize);
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        if (this.size == 0 || another.size == 0) {
            // kết quả là đa thức 0
            this.size = 0;
            return this;
        }
        int newSize = this.size + another.size - 1;
        double[] result = new double[newSize];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < another.size; j++) {
                result[i + j] += this.coefficents[i] * another.coefficents[j];
            }
        }
        // cập nhật về this
        this.size = newSize;
        if (coefficents.length < newSize) {
            coefficents = new double[newSize];
        }
        System.arraycopy(result, 0, this.coefficents, 0, newSize);
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        int newCap = coefficents.length * 2;
        double[] temp = new double[newCap];
        System.arraycopy(coefficents, 0, temp, 0, coefficents.length);
        coefficents = temp;
    }
}
