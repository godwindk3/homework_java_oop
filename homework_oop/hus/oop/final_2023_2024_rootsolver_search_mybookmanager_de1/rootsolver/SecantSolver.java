package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.rootsolver;

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
        for (int i = 0; i < maxIterations; i++) {
            if (Math.abs(f1) < tolerance) {
                return x1;
            }
            if (f1 - f0 == 0) {
                throw new RuntimeException("Chia cho 0, không thể tiếp tục");
            }
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = function.evaluate(x2);
        }
        throw new RuntimeException("Không tìm thấy nghiệm trong số lần lặp cho phép");
    }
}
