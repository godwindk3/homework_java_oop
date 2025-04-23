package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_MyPolynomial;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    public ListPolynomial() {
        this.coefficients = new ArrayList<>();
    }

    public ListPolynomial(double[] coeffs) {
        this.coefficients = new ArrayList<>();
        for (double coeff : coeffs) {
            this.coefficients.add(coeff);
        }
    }

    @Override
    public double coefficientAt(int index) {
        checkBoundaries(index, coefficients.size() - 1);
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] coeffs = new double[this.coefficients.size()];
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = this.coefficients.get(i);
        }
        return coeffs;
    }

    @Override
    public int degree() {
        if (coefficients.isEmpty()) return 0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public Polynomial derivative() {
        if (this.coefficients.size() <= 1) {
            return new ListPolynomial(new double[]{0});
        }
        return new ListPolynomial(derive());
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = this.coefficients.size() - 1; i >= 0; i--) {
            result = result * x + this.coefficients.get(i);
        }
        return result;
    }

    @Override
    public void insertAtEnd(double coeff) {
        this.coefficients.add(coeff);
    }

    @Override
    public void insertAtPosition(int index, double coeff) {
        checkBoundaries(index, coefficients.size());
        coefficients.add(index, coeff);
    }

    @Override
    public void insertAtStart(double coeff) {
        coefficients.add(0, coeff);
    }


    public ListPolynomial minus(ListPolynomial right) {
        double[] newCoeffs = new double[Math.max(this.coefficients.size(), right.coefficients.size())];
        int shorter = Math.min(this.coefficients.size(), right.coefficients.size());
        int longer = Math.max(this.coefficients.size(), right.coefficients.size());
        for (int i = 0; i < shorter; i++) {
            newCoeffs[i] = this.coefficients.get(i) - right.coefficients.get(i);
        }
        if (this.coefficients.size() > right.coefficients.size()) {
            for (int i = shorter; i < this.coefficients.size(); i++) {
                newCoeffs[i] = this.coefficients.get(i);
            }
        } else if (right.coefficients.size() > this.coefficients.size()) {
            for (int i = shorter; i < right.coefficients.size(); i++) {
                newCoeffs[i] = -right.coefficients.get(i);
            }
        }
        return new ListPolynomial(newCoeffs);
    }

    public ListPolynomial multiply(ListPolynomial right) {
        double[] newCoeffs = new double[coefficients.size() + right.coefficients.size() - 1];
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < right.coefficients.size(); j++) {
                newCoeffs[i + j] += coefficients.get(i) * right.coefficients.get(j);
            }
        }
        return new ListPolynomial(newCoeffs);
    }

    public ListPolynomial plus(ListPolynomial right) {
        double[] newCoeffs = new double[Math.max(this.coefficients.size(), right.coefficients.size())];
        int shorter = Math.min(this.coefficients.size(), right.coefficients.size());
        int longer = Math.max(this.coefficients.size(), right.coefficients.size());
        for (int i = 0; i < shorter; i++) {
            newCoeffs[i] = this.coefficients.get(i) + right.coefficients.get(i);
        }
        if (this.coefficients.size() > right.coefficients.size()) {
            for (int i = shorter; i < this.coefficients.size(); i++) {
                newCoeffs[i] = this.coefficients.get(i);
            }
        } else if (right.coefficients.size() > this.coefficients.size()) {
            for (int i = shorter; i < right.coefficients.size(); i++) {
                newCoeffs[i] = right.coefficients.get(i);
            }
        }
        return new ListPolynomial(newCoeffs);
    }

    @Override
    public void set(int index, double coeff) {
        checkBoundaries(index, coefficients.size() - 1);
        coefficients.set(index, coeff);
    }


}
