package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.integration;

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
            return 0.0;
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
        int n = coefficients.size();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = coefficients.get(i);
        }
        return arr;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtStart(double coefficient) {
        /* TODO */
        coefficients.add(0, coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtEnd(double coefficient) {
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
    public ListPolynomial insertAtPosition(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficients.size()) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        coefficients.add(index, coefficient);
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
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        if (coefficients.isEmpty()) {
            return -1;
        }
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0.0;
        double pow = 1.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * pow;
            pow *= x;
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public ListPolynomial derivative() {
        /* TODO */
        double[] derivArr = differentiate();
        ListPolynomial derivPoly = new ListPolynomial();
        for (double v : derivArr) {
            derivPoly.insertAtEnd(v);
        }
        return derivPoly;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ListPolynomial plus(Polynomial another) {
        /* TODO */
        double[] a = this.coefficients();
        double[] b = another.coefficients();
        int maxLen = Math.max(a.length, b.length);
        ListPolynomial sum = new ListPolynomial();
        for (int i = 0; i < maxLen; i++) {
            double av = (i < a.length ? a[i] : 0.0);
            double bv = (i < b.length ? b[i] : 0.0);
            sum.insertAtEnd(av + bv);
        }
        return sum;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plusTo(Polynomial another) {
        /* TODO */
        double[] b = another.coefficients();
        for (int i = 0; i < b.length; i++) {
            if (i < this.coefficients.size()) {
                this.coefficients.set(i, this.coefficients.get(i) + b[i]);
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
    public ListPolynomial minus(Polynomial another) {
        /* TODO */
        double[] a = this.coefficients();
        double[] b = another.coefficients();
        int maxLen = Math.max(a.length, b.length);
        ListPolynomial diff = new ListPolynomial();
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
    public ListPolynomial minusFrom(Polynomial another) {
        /* TODO */
        double[] b = another.coefficients();
        for (int i = 0; i < b.length; i++) {
            if (i < this.coefficients.size()) {
                this.coefficients.set(i, this.coefficients.get(i) - b[i]);
            } else {
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
    public ListPolynomial multiply(Polynomial another) {
        /* TODO */
        double[] a = this.coefficients();
        double[] b = another.coefficients();
        int newLen = a.length + b.length - 1;
        ListPolynomial prod = new ListPolynomial();
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
    public ListPolynomial multiplyBy(Polynomial another) {
        /* TODO */
        ListPolynomial prod = this.multiply(another);
        this.coefficients.clear();
        for (double v : prod.coefficients()) {
            this.insertAtEnd(v);
        }
        return this;
    }
}
