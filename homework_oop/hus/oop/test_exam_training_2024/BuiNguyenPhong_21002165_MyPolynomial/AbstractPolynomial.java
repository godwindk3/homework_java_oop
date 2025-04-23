package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_MyPolynomial;

public abstract class AbstractPolynomial implements Polynomial {
    public AbstractPolynomial() {
    }

    void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        double[] coeffs = coefficients();
        int maxDegree = degree(); // Lấy bậc cao nhất từ phương thức degree()

        // Duyệt từ bậc 0 đến bậc cao nhất
        for (int i = 0; i <= maxDegree && i < coeffs.length; i++) {
            if (coeffs[i] != 0) {
                // Xử lý hệ số để in số nguyên nếu có thể
                String coeffStr;
                if (Math.abs(coeffs[i] - (int) coeffs[i]) < 1e-10) {
                    coeffStr = String.valueOf((int) coeffs[i]);
                } else {
                    coeffStr = String.valueOf(coeffs[i]);
                }

                if (firstTerm) {
                    if (coeffs[i] < 0) {
                        sb.append("-").append(coeffStr);
                    } else {
                        sb.append(coeffStr);
                    }
                    firstTerm = false;
                } else {
                    if (coeffs[i] > 0) {
                        sb.append(" + ").append(coeffStr);
                    } else {
                        sb.append(" - ").append(coeffStr);
                    }
                }

                // Thêm x hoặc x^i nếu không phải hằng số
                if (i == 1) {
                    sb.append("x");
                } else if (i > 1) {
                    sb.append("x^").append(i);
                }
            }
        }

        // Nếu không có hệ số nào khác 0, trả về "0"
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
