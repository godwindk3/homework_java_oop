package hus.oop.final_2022_2023_matrix_integration_studentmanager.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        double[] coeffs = coefficients();
        if (coeffs.length == 0) {
            return "[0]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < coeffs.length; i++) {
            double c = coeffs[i];
            // Hiển thị hệ số
            if (i == 0) {
                sb.append(c);
            } else {
                sb.append(" + ").append(c).append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        double[] coeffs = coefficients();
        int n = coeffs.length;
        if (n <= 1) {
            return new double[0];
        }
        double[] deriv = new double[n - 1];
        for (int i = 1; i < n; i++) {
            deriv[i - 1] = i * coeffs[i];
        }
        return deriv;
    }
}
