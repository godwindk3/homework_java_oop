package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.integration;

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
        int iter = 0;
        while (true) {
            n *= 2;
            if (n % 2 != 0) { n++; }
            double I2n = integrate(poly, lower, upper, n);
            if (Math.abs(I2n - In) / 15.0 < precision) {
                return I2n;
            }
            In = I2n;
            iter++;
            if (iter >= maxIterations) {
                return I2n;
            }
        }
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
        if (numOfSubIntervals % 2 != 0) {
            numOfSubIntervals++; // đảm bảo chẵn
        }
        double h = (upper - lower) / numOfSubIntervals;
        double sum = poly.evaluate(lower) + poly.evaluate(upper);

        // các điểm odd index (4 lần)
        for (int i = 1; i < numOfSubIntervals; i += 2) {
            double x = lower + i * h;
            sum += 4.0 * poly.evaluate(x);
        }
        // các điểm even index (2 lần)
        for (int i = 2; i < numOfSubIntervals; i += 2) {
            double x = lower + i * h;
            sum += 2.0 * poly.evaluate(x);
        }
        return sum * h / 3.0;
    }
}
