package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
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
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double fLower = function.evaluate(lower);
        double fUpper = function.evaluate(upper);

        if (fLower * fUpper > 0) {
            throw new IllegalArgumentException(
                    "BisectionSolver: f(lower) và f(upper) phải khác dấu để đảm bảo có nghiệm trong khoảng."
            );
        }

        double mid = lower;
        double fMid;
        int iter = 0;
        while (iter < maxIterations) {
            mid = 0.5 * (lower + upper);
            fMid = function.evaluate(mid);

            if (Math.abs(fMid) < tolerance || (upper - lower) / 2.0 < tolerance) {
                return mid;
            }

            // Chọn nửa khoảng chứa nghiệm
            if (fLower * fMid <= 0) {
                upper = mid;
                fUpper = fMid;
            } else {
                lower = mid;
                fLower = fMid;
            }

            iter++;
        }

        // Sau tối đa iter vẫn chưa đủ điều kiện, trả về mid gần đúng cuối cùng
        return mid;
    }
}
