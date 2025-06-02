package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.integration;

public class MidpointMethod extends AbstractIntegrator {
    public MidpointMethod(double precision, int maxIterations) {
        /* TODO */
        super(precision, maxIterations);
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng lặp vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n_0 tùy ý, sau đó tính I_n với n = n_0, 2n_0, 4n_0, ...
     * Việc tính toán dừng lại khi |I_2n - I_n|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     *
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */
        int n = 4; // Bắt đầu với n_0 = 4
        double previousResult = integrate(polynomial, lower, upper, n);

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            n *= 2; // Tăng gấp đôi số khoảng
            double currentResult = integrate(polynomial, lower, upper, n);

            // Kiểm tra độ chính xác
            if (Math.abs(currentResult - previousResult) / 3.0 < precision) {
                return currentResult;
            }

            previousResult = currentResult;
        }

        return previousResult;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     *
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0;

        for (int i = 0; i < numOfSubIntervals; i++) {
            double midpoint = lower + (i + 0.5) * h;
            sum += polynomial.evaluate(midpoint);
        }

        return sum * h;
    }
}
