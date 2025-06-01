package hus.oop.final_2022_2023_matrix_integration_studentmanager.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        this.coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            return 0;
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] arr = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            arr[i] = coefficients.get(i);
        }
        return arr;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0) {
            throw new IllegalArgumentException("Index phải >= 0");
        }
        if (index > coefficients.size()) {
            // mở rộng bằng 0 cho đến khi đạt index
            for (int i = coefficients.size(); i < index; i++) {
                coefficients.add(0.0);
            }
            coefficients.add(coefficient);
        } else {
            coefficients.add(index, coefficient);
        }
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0) {
            throw new IllegalArgumentException("Index phải >= 0");
        }
        if (index >= coefficients.size()) {
            for (int i = coefficients.size(); i < index; i++) {
                coefficients.add(0.0);
            }
            coefficients.add(coefficient);
        } else {
            coefficients.set(index, coefficient);
        }
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        int n = coefficients.size();
        if (n == 0) {
            return 0;
        }
        double result = coefficients.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] derivCoeffs = differentiate();
        ListPolynomial derivPoly = new ListPolynomial();
        for (double c : derivCoeffs) {
            derivPoly.append(c);
        }
        return derivPoly;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0.0;
            double b = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0.0;
            result.add(a + b);
        }
        this.coefficients = result;
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            double a = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0.0;
            double b = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0.0;
            result.add(a - b);
        }
        this.coefficients = result;
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        int n1 = this.coefficients.size();
        int n2 = another.coefficients.size();
        if (n1 == 0 || n2 == 0) {
            this.coefficients.clear();
            return this;
        }
        int newSize = n1 + n2 - 1;
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < newSize; i++) {
            result.add(0.0);
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                double prev = result.get(i + j);
                result.set(i + j, prev + this.coefficients.get(i) * another.coefficients.get(j));
            }
        }
        this.coefficients = result;
        return this;
    }
}
