package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double result = 0;
        double term = x;
        int n = 1;

        // Chuẩn hóa x về khoảng [-π, π]
        while (x > Math.PI) x -= 2 * Math.PI;
        while (x < -Math.PI) x += 2 * Math.PI;

        term = x;
        for (int i = 0; i < 20; i++) {
            result += term;
            term *= -x * x / ((2 * n) * (2 * n + 1));
            n++;
        }
        return result;
    }

    public static double cos(double x) {
        /* TODO */
        // Sử dụng chuỗi Taylor để tính cos(x)
        // cos(x) = 1 - x^2/2! + x^4/4! - x^6/6! + ...
        double result = 0;
        double term = 1;
        int n = 1;

        // Chuẩn hóa x về khoảng [-π, π]
        while (x > Math.PI) x -= 2 * Math.PI;
        while (x < -Math.PI) x += 2 * Math.PI;

        for (int i = 0; i < 20; i++) {
            result += term;
            term *= -x * x / ((2 * n - 1) * (2 * n));
            n++;
        }
        return result;
    }

    public double exp(double x) {
        /* TODO */
        // Sử dụng chuỗi Taylor để tính e^x
        // e^x = 1 + x + x^2/2! + x^3/3! + ...
        double result = 1;
        double term = 1;

        for (int i = 1; i < 50; i++) {
            term *= x / i;
            result += term;
            if (Math.abs(term) < 1e-15) break;
        }
        return result;
    }

    public double ln(double x) {
        /* TODO */
        if (x <= 0) {
            throw new IllegalArgumentException("ln(x) không xác định với x <= 0");
        }

        // Sử dụng chuỗi Taylor cho ln(1+u) với u = (x-1)/(x+1)
        // ln(x) = 2 * [u + u^3/3 + u^5/5 + ...] với u = (x-1)/(x+1)
        double u = (x - 1) / (x + 1);
        double u2 = u * u;
        double result = 0;
        double term = u;

        for (int i = 1; i < 100; i += 2) {
            result += term / i;
            term *= u2;
            if (Math.abs(term / i) < 1e-15) break;
        }
        return 2 * result;
    }
}
