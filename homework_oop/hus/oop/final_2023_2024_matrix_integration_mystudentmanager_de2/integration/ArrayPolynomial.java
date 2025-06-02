package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.integration;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficients;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficients = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            return 0.0;
        }
        return coefficients[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        return Arrays.copyOf(coefficients, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtStart(double coefficient) {
        /* TODO */
        if (size == coefficients.length) {
            enlarge();
        }
        // đẩy sang phải
        for (int i = size; i >= 1; i--) {
            coefficients[i] = coefficients[i - 1];
        }
        coefficients[0] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtEnd(double coefficient) {
        /* TODO */
        if (size == coefficients.length) {
            enlarge();
        }
        coefficients[size++] = coefficient;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtPosition(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        if (size == coefficients.length) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            coefficients[i] = coefficients[i - 1];
        }
        coefficients[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        coefficients[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        if (size == 0) {
            return -1;
        }
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0.0;
        double pow = 1.0;
        for (int i = 0; i < size; i++) {
            result += coefficients[i] * pow;
            pow *= x;
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public ArrayPolynomial derivative() {
        /* TODO */
        double[] derivArr = differentiate(); // dùng từ AbstractPolynomial
        ArrayPolynomial derivPoly = new ArrayPolynomial();
        for (int i = 0; i < derivArr.length; i++) {
            derivPoly.insertAtEnd(derivArr[i]);
        }
        return derivPoly;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ArrayPolynomial plus(Polynomial another) {
        /* TODO */
        double[] a = this.coefficients();
        double[] b = another.coefficients();
        int maxLen = Math.max(a.length, b.length);
        ArrayPolynomial sum = new ArrayPolynomial();
        for (int i = 0; i < maxLen; i++) {
            double av = (i < a.length ? a[i] : 0.0);
            double bv = (i < b.length ? b[i] : 0.0);
            sum.insertAtEnd(av + bv);
        }
        return sum;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plusTo(Polynomial another) {
        /* TODO */
        double[] b = another.coefficients();
        for (int i = 0; i < b.length; i++) {
            if (i < this.size) {
                this.coefficients[i] += b[i];
            } else {
                this.insertAtEnd(b[i]);
            }
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ArrayPolynomial minus(Polynomial another) {
        /* TODO */
        double[] a = this.coefficients();
        double[] b = another.coefficients();
        int maxLen = Math.max(a.length, b.length);
        ArrayPolynomial diff = new ArrayPolynomial();
        for (int i = 0; i < maxLen; i++) {
            double av = (i < a.length ? a[i] : 0.0);
            double bv = (i < b.length ? b[i] : 0.0);
            diff.insertAtEnd(av - bv);
        }
        return diff;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minusFrom(Polynomial another) {
        /* TODO */
        double[] b = another.coefficients();
        for (int i = 0; i < b.length; i++) {
            if (i < this.size) {
                this.coefficients[i] -= b[i];
            } else {
                // nếu another có bậc cao hơn, thì kết quả vẫn phải thêm -b[i]
                this.insertAtEnd(-b[i]);
            }
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ArrayPolynomial multiply(Polynomial another) {
        /* TODO */
        double[] a = this.coefficients();
        double[] b = another.coefficients();
        int newLen = a.length + b.length - 1;
        ArrayPolynomial prod = new ArrayPolynomial();
        // khởi tạo mảng tạm chứa kết quả
        double[] temp = new double[newLen];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                temp[i + j] += a[i] * b[j];
            }
        }
        for (double v : temp) {
            prod.insertAtEnd(v);
        }
        return prod;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiplyBy(Polynomial another) {
        /* TODO */
        double[] resultArr = this.multiply(another).coefficients();
        // reset this
        this.size = 0;
        if (resultArr.length > this.coefficients.length) {
            this.coefficients = new double[resultArr.length];
        }
        for (double v : resultArr) {
            this.insertAtEnd(v);
        }
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        int newCapacity = this.coefficients.length * 2;
        this.coefficients = Arrays.copyOf(this.coefficients, newCapacity);
    }
}
