package hus.oop.train_lab9.polynomials;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractPoly implements Poly {


    double[] derive() {
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[]{0};
        }
        double[] derived = new double[coeffs.length - 1];
        for (int i = 0; i < coeffs.length - 1; i++) {
            derived[i] = coeffs[i + 1] * (i + 1);
        }
        return derived;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Poly)) {
            return false;
        } else {
            return Arrays.equals(coefficients(), ((Poly) o).coefficients());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coefficients());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        double[] coeffs = coefficients();

        for (int i = 0; i < coeffs.length; i++) {
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

}
