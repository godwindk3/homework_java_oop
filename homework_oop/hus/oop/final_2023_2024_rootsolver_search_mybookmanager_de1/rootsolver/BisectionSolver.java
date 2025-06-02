package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     *
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     *
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double a = lower;
        double b = upper;
        double fa = function.evaluate(a);
        double fb = function.evaluate(b);
        if (fa * fb >= 0) {
            throw new IllegalArgumentException("Hàm không đổi dấu trên [lower, upper]");
        }
        for (int i = 0; i < maxIterations; i++) {
            double c = (a + b) / 2;
            double fc = function.evaluate(c);
            if (Math.abs(fc) < tolerance) {
                return c;
            }
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }
        throw new RuntimeException("Không tìm thấy nghiệm trong số lần lặp cho phép");
    }
}
