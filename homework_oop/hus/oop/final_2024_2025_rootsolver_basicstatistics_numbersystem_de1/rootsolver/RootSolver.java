package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.rootsolver;

public interface RootSolver {
    /**
     * Tìm nghiệm của hàm một biến trong đoạn [lower, upper]
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    double solve(AbstractFunction function, double lower, double upper);
}
