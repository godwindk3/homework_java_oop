package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        return MyMath.sin(x) * x - 3;
    }

    @Override
    public double derivative(double x) {
        /* TODO */
        return MyMath.cos(x) * x + MyMath.sin(x);
    }
}
