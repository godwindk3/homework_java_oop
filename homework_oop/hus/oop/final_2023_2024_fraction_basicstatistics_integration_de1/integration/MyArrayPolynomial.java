package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.integration;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficients;
    private int length;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        /* TODO */
        coefficients = new double[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= length) {
            return 0;
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
        double[] result = new double[length];
        System.arraycopy(coefficients, 0, result, 0, length);
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial append(double coefficient) {
        /* TODO */
        if (length >= coefficients.length) {
            enlarge();
        }
        coefficients[length] = coefficient;
        length++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không thêm được.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index > length) {
            return this;
        }

        if (length >= coefficients.length) {
            enlarge();
        }

        // Dịch chuyển các phần tử về phía sau
        for (int i = length; i > index; i--) {
            coefficients[i] = coefficients[i - 1];
        }

        coefficients[index] = coefficient;
        length++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index >= 0 && index < length) {
            coefficients[index] = coefficient;
        }
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return length - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        double power = 1;

        for (int i = 0; i < length; i++) {
            result += coefficients[i] * power;
            power *= x;
        }

        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public MyPolynomial derivative() {
        /* TODO */
        MyArrayPolynomial derivative = new MyArrayPolynomial();

        if (length <= 1) {
            derivative.append(0);
            return derivative;
        }

        for (int i = 1; i < length; i++) {
            derivative.append(i * coefficients[i]);
        }

        return derivative;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial plus(MyArrayPolynomial another) {
        /* TODO */
        int maxLength = Math.max(this.length, another.length);

        // Mở rộng mảng nếu cần
        while (coefficients.length < maxLength) {
            enlarge();
        }

        // Cộng các hệ số
        for (int i = 0; i < maxLength; i++) {
            double thisCoeff = (i < this.length) ? this.coefficients[i] : 0;
            double otherCoeff = (i < another.length) ? another.coefficients[i] : 0;

            if (i < this.length) {
                this.coefficients[i] = thisCoeff + otherCoeff;
            } else {
                this.append(otherCoeff);
            }
        }

        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial minus(MyArrayPolynomial another) {
        /* TODO */
        int maxLength = Math.max(this.length, another.length);

        // Mở rộng mảng nếu cần
        while (coefficients.length < maxLength) {
            enlarge();
        }

        // Trừ các hệ số
        for (int i = 0; i < maxLength; i++) {
            double thisCoeff = (i < this.length) ? this.coefficients[i] : 0;
            double otherCoeff = (i < another.length) ? another.coefficients[i] : 0;

            if (i < this.length) {
                this.coefficients[i] = thisCoeff - otherCoeff;
            } else {
                this.append(-otherCoeff);
            }
        }

        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public MyArrayPolynomial multiply(MyArrayPolynomial another) {
        /* TODO */
        if (this.length == 0 || another.length == 0) {
            this.length = 1;
            this.coefficients[0] = 0;
            return this;
        }

        int newLength = this.length + another.length - 1;
        double[] newCoeffs = new double[newLength];

        // Nhân các hệ số
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < another.length; j++) {
                newCoeffs[i + j] += this.coefficients[i] * another.coefficients[j];
            }
        }

        // Cập nhật mảng hệ số
        while (coefficients.length < newLength) {
            enlarge();
        }

        System.arraycopy(newCoeffs, 0, this.coefficients, 0, newLength);
        this.length = newLength;

        return this;
    }

    /**
     * Tăng kích thước gấp đôi để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        double[] newCoeffs = new double[coefficients.length * 2];
        System.arraycopy(coefficients, 0, newCoeffs, 0, length);
        coefficients = newCoeffs;
    }
}
