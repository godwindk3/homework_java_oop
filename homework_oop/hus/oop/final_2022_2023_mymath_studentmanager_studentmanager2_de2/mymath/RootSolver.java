package hus.oop.final_2022_2023_mymath_studentmanager_studentmanager2_de2.mymath;


public interface RootSolver {
    /**
     * Tìm nghiệm của đa thức trong khoảng [lower, upper]
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    double solve(AbstractFunction polynomial, double lower, double upper);
}
