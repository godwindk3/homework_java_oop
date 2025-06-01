package hus.oop.final_2023_2024_fraction_basicstatistics_integration.integration;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        double[] coeffs = coefficients();

        if (coeffs.length == 0) {
            return "0";
        }

        boolean first = true;
        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] != 0) {
                if (!first && coeffs[i] > 0) {
                    sb.append(" + ");
                } else if (!first && coeffs[i] < 0) {
                    sb.append(" - ");
                    coeffs[i] = -coeffs[i]; // Make positive for display
                }

                if (i == 0) {
                    sb.append(coeffs[i]);
                } else if (i == 1) {
                    if (coeffs[i] == 1) {
                        sb.append("x");
                    } else {
                        sb.append(coeffs[i]).append("x");
                    }
                } else {
                    if (coeffs[i] == 1) {
                        sb.append("x^").append(i);
                    } else {
                        sb.append(coeffs[i]).append("x^").append(i);
                    }
                }
                first = false;
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[]{0};
        }

        double[] derivative = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derivative[i - 1] = i * coeffs[i];
        }

        return derivative;
    }
}
