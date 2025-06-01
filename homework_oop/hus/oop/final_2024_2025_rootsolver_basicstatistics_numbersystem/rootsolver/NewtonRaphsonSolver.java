package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        // Chọn điểm khởi đầu là midpoint của [lower, upper]
        double x = 0.5 * (lower + upper);
        double fx, fpx;

        for (int iter = 0; iter < maxIterations; iter++) {
            fx = function.evaluate(x);
            fpx = function.derivative(x);

            if (Math.abs(fpx) < 1e-15) {
                // Tránh chia cho 0, thoát vòng lặp
                break;
            }

            double xNew = x - fx / fpx;

            if (Double.isNaN(xNew) || Double.isInfinite(xNew)) {
                // Nếu tính ra NaN / Infinite thì thoát
                break;
            }

            if (Math.abs(function.evaluate(xNew)) < tolerance || Math.abs(xNew - x) < tolerance) {
                return xNew;
            }
            x = xNew;
        }

        // Nếu không hội tụ đủ thì trả về giá trị cuối cùng
        return x;
    }
}
