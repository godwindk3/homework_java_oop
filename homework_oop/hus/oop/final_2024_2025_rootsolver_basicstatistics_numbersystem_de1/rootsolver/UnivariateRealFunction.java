package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        // Hàm f(x) = sin(x) * x - 3
        return MyMath.sin(x) * x - 3;
    }

    @Override
    public double derivative(double x) {
        /* TODO */
        // Đạo hàm f'(x) = sin(x) + x * cos(x)
        return MyMath.cos(x) * x + MyMath.sin(x);
    }
}
