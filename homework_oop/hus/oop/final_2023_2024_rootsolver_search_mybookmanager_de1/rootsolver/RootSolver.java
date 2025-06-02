package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.rootsolver;

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
