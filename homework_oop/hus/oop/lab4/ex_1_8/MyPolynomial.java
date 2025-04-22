package hus.oop.lab4.ex_1_8;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return this.coeffs.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        for (int i = 0; i < this.coeffs.length; i++) {
            if (coeffs[i] != 0) {
                if (firstTerm) {
                    sb.append(coeffs[i]);
                    firstTerm = false;
                } else {
                    if (coeffs[i] > 0) {
                        sb.append(" + ").append(coeffs[i]);
                    } else {
                        sb.append(" - ").append(-coeffs[i]);
                    }
                }
                if (i == 1) {
                    sb.append("x");
                } else if (i > 1) {
                    sb.append("x^").append(i);
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = this.coeffs.length - 1; i >= 0; i--) {
            result = result * x + this.coeffs[i];
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] newCoeffs = new double[Math.max(this.coeffs.length, right.coeffs.length)];
        int shorter = Math.min(this.coeffs.length, right.coeffs.length);

        for (int i = 0; i < shorter; i++) {
            newCoeffs[i] = this.coeffs[i] + right.coeffs[i];
        }
        if (this.coeffs.length > right.coeffs.length) {
            for (int i = shorter; i < this.coeffs.length; i++) {
                newCoeffs[i] = this.coeffs[i];
            }
        } else if (right.coeffs.length > this.coeffs.length) {
            for (int i = shorter; i < right.coeffs.length; i++) {
                newCoeffs[i] = right.coeffs[i];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] newCoeffs = new double[this.coeffs.length + right.coeffs.length - 1];
        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

}
