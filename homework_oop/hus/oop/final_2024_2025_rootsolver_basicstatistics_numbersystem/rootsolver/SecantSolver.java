package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp Secant
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm trong đoạn [lower, upper]
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x0 = lower;
        double x1 = upper;
        double f0 = function.evaluate(x0);
        double f1 = function.evaluate(x1);

        for (int iter = 0; iter < maxIterations; iter++) {
            if (Math.abs(f1 - f0) < 1e-15) {
                // Trường hợp chia cho gần 0, thoát ra
                break;
            }
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double f2 = function.evaluate(x2);

            if (Math.abs(f2) < tolerance || Math.abs(x2 - x1) < tolerance) {
                return x2;
            }

            // Cập nhật x0, x1
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;
        }
        // Nếu vượt maxIterations thì trả về giá trị gần đúng cuối cùng
        return x1;
    }
}
