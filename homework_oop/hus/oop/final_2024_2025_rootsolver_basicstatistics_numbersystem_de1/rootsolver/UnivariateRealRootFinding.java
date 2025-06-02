package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.rootsolver;

public class UnivariateRealRootFinding {
    private AbstractFunction function;
    private RootSolver rootSolver;

    /**
     * Khởi tạo hàm.
     * @param function
     */
    public UnivariateRealRootFinding(AbstractFunction function) {
        /* TODO */
        this.function = function;
    }

    /**
     * Khởi tạo hàm và phương pháp tìm nghiệm.
     * @param function
     * @param rootSolver
     */
    public UnivariateRealRootFinding(AbstractFunction function, RootSolver rootSolver) {
        /* TODO */
        this.function = function;
        this.rootSolver = rootSolver;
    }

    public void setFunction(AbstractFunction function) {
        /* TODO */
        this.function = function;
    }

    public void setRootSolver(RootSolver rootSolver) {
        /* TODO */
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của hàm trong đoạn [lower, upper].
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    public double solve(double lower, double upper) {
        /* TODO */
        if (rootSolver == null) {
            throw new IllegalStateException("RootSolver chưa được thiết lập");
        }
        return rootSolver.solve(function, lower, upper);
    }
}
