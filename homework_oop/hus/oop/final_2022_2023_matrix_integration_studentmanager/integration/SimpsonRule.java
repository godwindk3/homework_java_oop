package hus.oop.final_2022_2023_matrix_integration_studentmanager.integration;

public class SimpsonRule implements Integrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        /* TODO */
        int n = 2;
        double In = integrate(poly, lower, upper, n);
        for (int iter = 1; iter <= maxIterations; iter++) {
            n *= 2;
            if (n % 2 != 0) {
                n++; // đảm bảo n chẵn
            }
            double I2n = integrate(poly, lower, upper, n);
            if (Math.abs(I2n - In) / 15.0 < precision) {
                return I2n;
            }
            In = I2n;
        }
        return In;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     * @param poly
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        if (numOfSubIntervals < 2) {
            numOfSubIntervals = 2;
        }
        if (numOfSubIntervals % 2 != 0) {
            numOfSubIntervals++;
        }
        double h = (upper - lower) / numOfSubIntervals;
        double sum = poly.evaluate(lower) + poly.evaluate(upper);

        // các hệ số 4 và 2 xen kẽ
        double s4 = 0;
        double s2 = 0;
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            if (i % 2 == 1) {
                s4 += poly.evaluate(x);
            } else {
                s2 += poly.evaluate(x);
            }
        }
        sum += 4 * s4 + 2 * s2;
        return sum * (h / 3.0);
    }
}
