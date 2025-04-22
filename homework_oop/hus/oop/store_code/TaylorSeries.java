package hus.oop.store_code;

public class TaylorSeries {
    private static final double PI = Math.PI;
    private static final int MAX_TERMS = 20; // Số số hạng Taylor để đạt độ chính xác

    // Hàm tính sin(x) theo chuỗi Taylor
    public static double sin(double x) {
        // Đưa x về khoảng [-π, π] để tăng độ chính xác
        x = x % (2 * PI);
        if (x > PI) x -= 2 * PI;
        if (x < -PI) x += 2 * PI;

        double result = 0.0;
        double term = x; // Số hạng đầu tiên: x
        double xSquared = x * x;

        for (int n = 0; n < MAX_TERMS; n++) {
            result += term;
            // Tính số hạng tiếp theo: term = -term * x^2 / ((2n+2)(2n+3))
            term *= -xSquared / ((2 * n + 2) * (2 * n + 3));
        }

        return result;
    }

    // Hàm tính cos(x) theo chuỗi Taylor
    public static double cos(double x) {
        // Đưa x về khoảng [-π, π]
        x = x % (2 * PI);
        if (x > PI) x -= 2 * PI;
        if (x < -PI) x += 2 * PI;

        double result = 0.0;
        double term = 1.0; // Số hạng đầu tiên: 1
        double xSquared = x * x;

        for (int n = 0; n < MAX_TERMS; n++) {
            result += term;
            // Tính số hạng tiếp theo: term = -term * x^2 / ((2n+1)(2n+2))
            term *= -xSquared / ((2 * n + 1) * (2 * n + 2));
        }

        return result;
    }

    // Hàm tính exp(x) theo chuỗi Taylor
    public static double exp(double x) {
        // Kiểm tra giá trị lớn để tránh tràn số
        if (Math.abs(x) > 709) { // exp(709) là giới hạn an toàn cho double
            throw new IllegalArgumentException("Giá trị x quá lớn cho exp(x)");
        }

        double result = 0.0;
        double term = 1.0; // Số hạng đầu tiên: 1

        for (int n = 0; n < MAX_TERMS; n++) {
            result += term;
            // Tính số hạng tiếp theo: term = term * x / (n+1)
            term *= x / (n + 1);
        }

        return result;
    }

    // Main để thử nghiệm
    public static void main(String[] args) {
        // Thử nghiệm sin
        System.out.println("sin(π/6) ≈ " + sin(PI / 6)); // Mong muốn: ~0.5
        System.out.println("Math.sin(π/6) = " + Math.sin(PI / 6));

        // Thử nghiệm cos
        System.out.println("cos(π/3) ≈ " + cos(PI / 3)); // Mong muốn: ~0.5
        System.out.println("Math.cos(π/3) = " + Math.cos(PI / 3));

        // Thử nghiệm exp
        System.out.println("exp(1) ≈ " + exp(1)); // Mong muốn: ~2.71828
        System.out.println("Math.exp(1) = " + Math.exp(1));
    }
}
