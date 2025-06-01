package hus.oop.final_2023_2024_fraction_basicstatistics_integration.integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     *
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
     *
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public MyListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, coefficients.length()] thì không thêm được.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyListPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > coefficients.size()) {
            return this;
        }
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index >= 0 && index < coefficients.size()) {
            coefficients.set(index, coefficient);
        }
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     *
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        double power = 1;

        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * power;
            power *= x;
        }

        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public MyPolynomial derivative() {
        /* TODO */
        MyListPolynomial derivative = new MyListPolynomial();

        if (coefficients.size() <= 1) {
            derivative.append(0);
            return derivative;
        }

        for (int i = 1; i < coefficients.size(); i++) {
            derivative.append(i * coefficients.get(i));
        }

        return derivative;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public MyListPolynomial plus(MyListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());

        // Mở rộng danh sách nếu cần
        while (this.coefficients.size() < maxSize) {
            this.coefficients.add(0.0);
        }

        // Cộng các hệ số
        for (int i = 0; i < maxSize; i++) {
            double thisCoeff = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double otherCoeff = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;

            if (i < this.coefficients.size()) {
                this.coefficients.set(i, thisCoeff + otherCoeff);
            } else {
                this.coefficients.add(otherCoeff);
            }
        }

        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public MyListPolynomial minus(MyListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());

        // Mở rộng danh sách nếu cần
        while (this.coefficients.size() < maxSize) {
            this.coefficients.add(0.0);
        }

        // Trừ các hệ số
        for (int i = 0; i < maxSize; i++) {
            double thisCoeff = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double otherCoeff = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;

            if (i < this.coefficients.size()) {
                this.coefficients.set(i, thisCoeff - otherCoeff);
            } else {
                this.coefficients.add(-otherCoeff);
            }
        }

        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public MyListPolynomial multiply(MyListPolynomial another) {
        /* TODO */
        if (this.coefficients.isEmpty() || another.coefficients.isEmpty()) {
            this.coefficients.clear();
            this.coefficients.add(0.0);
            return this;
        }

        int newSize = this.coefficients.size() + another.coefficients.size() - 1;
        List<Double> newCoeffs = new ArrayList<>();

        // Khởi tạo với 0
        for (int i = 0; i < newSize; i++) {
            newCoeffs.add(0.0);
        }

        // Nhân các hệ số
        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                double currentValue = newCoeffs.get(i + j);
                newCoeffs.set(i + j, currentValue + this.coefficients.get(i) * another.coefficients.get(j));
            }
        }

        this.coefficients = newCoeffs;
        return this;
    }
}
