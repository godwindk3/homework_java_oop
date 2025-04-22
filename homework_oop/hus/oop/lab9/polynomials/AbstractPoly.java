package hus.oop.lab9.polynomials;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractPoly implements Poly {
    double[] derive() {

        double[] coeffs = coefficients();
        if (coeffs.length <= 1) return new double[]{0};
        double[] derived = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derived[i - 1] = coeffs[i] * i;
        }
        return derived;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Poly)) return false;
        return Arrays.equals(this.coefficients(), ((Poly) o).coefficients());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Arrays.hashCode(coefficients()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double[] coeffs = coefficients();

        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (sb.length() > 0) sb.append(" + ");
                sb.append(coeffs[i]);
                if (i > 0) sb.append("*x");
                if (i > 1) sb.append("^").append(i);
            }
        }
        return sb.toString();
    }
}

