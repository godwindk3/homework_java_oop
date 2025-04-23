package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_MyPolynomial;

public class ArrayPolynomial extends AbstractPolynomial {
    private int DEFAULT_CAPACITY = 16;
    private double[] coefficients;
    private int size;
    private double[] newCoeffs;

    public ArrayPolynomial() {
        this.coefficients = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayPolynomial(double[] coefficients, int size) {
        if (size < 0 || size > coefficients.length) {
            throw new IllegalArgumentException("Invalid size");
        }
        this.coefficients = new double[coefficients.length];
        System.arraycopy(coefficients, 0, this.coefficients, 0, size);
        this.size = size;
    }

    private void allocateMore() {
        double[] newArray = new double[this.coefficients.length * 2];
        System.arraycopy(this.coefficients, 0, newArray, 0, this.size);
        this.coefficients = newArray;
    }

    @Override
    public double coefficientAt(int index) {
        checkBoundaries(index, this.size - 1);
        return this.coefficients[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficients, 0, result, 0, size);
        return result;
    }

    @Override
    public int degree() {
        if (size == 0) return 0; // Đa thức rỗng
        for (int i = size - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                return i;
            }
        }
        return 0; // Tất cả hệ số bằng 0
    }

    @Override
    public Polynomial derivative() {
        if (size <= 1) {
            return new ArrayPolynomial(new double[]{0}, 1);
        }
        return new ArrayPolynomial(derive(), this.size - 1);
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = size - 1; i >= 0; i--) {
            result = result * x + coefficients[i];
        }
        return result;
    }

    @Override
    public void insertAtEnd(double coeff) {
        if (this.size >= this.coefficients.length) {
            allocateMore();
        }
        this.coefficients[size] = coeff;
        this.size++;
    }

    @Override
    public void insertAtPosition(int index, double coeff) {
        checkBoundaries(index, size);
        if (size >= coefficients.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            coefficients[i] = coefficients[i - 1];
        }
        coefficients[index] = coeff;
        size++;
    }

    @Override
    public void insertAtStart(double coeff) {
        if (size >= coefficients.length) {
            allocateMore();
        }
        for (int i = size; i > 0; i--) {
            coefficients[i] = coefficients[i - 1];
        }
        coefficients[0] = coeff;
        size++;
    }


    public ArrayPolynomial minus(ArrayPolynomial right) {
        double[] newCoeffs = new double[Math.max(this.size, right.size)];
        int shorter = Math.min(this.size, right.size);
        int longer = Math.max(this.size, right.size);
        for (int i = 0; i < shorter; i++) {
            newCoeffs[i] = this.coefficients[i] - right.coefficients[i];
        }
        if (this.size > right.size) {
            for (int i = shorter; i < this.size; i++) {
                newCoeffs[i] = this.coefficients[i];
            }
        } else if (right.size > this.size) {
            for (int i = shorter; i < right.size; i++) {
                newCoeffs[i] = -right.coefficients[i];
            }
        }
        return new ArrayPolynomial(newCoeffs, longer);
    }

    public ArrayPolynomial multiply(ArrayPolynomial right) {
        double[] newCoeffs = new double[this.size + right.size - 1];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < right.size; j++) {
                newCoeffs[i + j] += this.coefficients[i] * right.coefficients[j];
            }
        }
        return new ArrayPolynomial(newCoeffs, newCoeffs.length);
    }

    public ArrayPolynomial plus(ArrayPolynomial right) {
        double[] newCoeffs = new double[Math.max(this.size, right.size)];
        int shorter = Math.min(this.size, right.size);
        int longer = Math.max(this.size, right.size);
        for (int i = 0; i < shorter; i++) {
            newCoeffs[i] = this.coefficients[i] + right.coefficients[i];
        }
        if (this.size > right.size) {
            for (int i = shorter; i < this.size; i++) {
                newCoeffs[i] = this.coefficients[i];
            }
        } else if (right.size > this.size) {
            for (int i = shorter; i < right.size; i++) {
                newCoeffs[i] = right.coefficients[i];
            }
        }
        return new ArrayPolynomial(newCoeffs, longer);
    }

    @Override
    public void set(int index, double coeff) {
        checkBoundaries(index, size - 1);
        coefficients[index] = coeff;
    }
}
