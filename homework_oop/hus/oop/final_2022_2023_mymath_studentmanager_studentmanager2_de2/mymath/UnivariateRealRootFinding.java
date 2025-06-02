package hus.oop.final_2022_2023_mymath_studentmanager_studentmanager2_de2.mymath;


public class UnivariateRealRootFinding {
    private AbstractFunction function;
    public AbstractFunction poly;
    public RootSolver rootSolver;

    public UnivariateRealRootFinding(AbstractFunction function) {
        this.function = function;
    }

    public UnivariateRealRootFinding(AbstractFunction function, RootSolver rootSolver) {
        this.function = function;
        this.rootSolver = rootSolver;
    }

    public double solve(double lower, double upper) {
        return rootSolver.solve(function, lower, upper);
    }
}
