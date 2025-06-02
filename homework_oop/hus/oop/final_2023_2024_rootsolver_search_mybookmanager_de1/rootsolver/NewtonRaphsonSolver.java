package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.rootsolver;

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
        double x = (lower + upper) / 2; // Bắt đầu từ điểm giữa
        for (int i = 0; i < maxIterations; i++) {
            double fx = function.evaluate(x);
            double dfx = function.derivative(x);
            if (Math.abs(fx) < tolerance) {
                return x;
            }
            if (dfx == 0) {
                throw new RuntimeException("Đạo hàm bằng 0, không thể tiếp tục");
            }
            x = x - fx / dfx;
        }
        throw new RuntimeException("Không tìm thấy nghiệm trong số lần lặp cho phép");
    }
}
