package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_MyPolynomial;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIteration;

    public NewtonRaphsonSolver(double tolerance, int maxIteration) {
        if (tolerance <= 0) {
            throw new IllegalArgumentException("Tolerance must be positive");
        }
        if (maxIteration <= 0) {
            throw new IllegalArgumentException("Max iteration must be positive");
        }
        this.tolerance = tolerance;
        this.maxIteration = maxIteration;
    }

    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        if (polynomial == null) {
            throw new IllegalArgumentException("Polynomial cannot be null");
        }

        Polynomial derivative = polynomial.derivative();
        double x = (lower + upper) / 2; // Start at midpoint

        for (int i = 0; i < maxIteration; i++) {
            double fx = polynomial.evaluate(x);
            if (Math.abs(fx) < tolerance) {
                return x;
            }

            double dfx = derivative.evaluate(x);
            if (Math.abs(dfx) < 1e-10) {
                throw new ArithmeticException("Derivative too small, method failed");
            }

            x = x - fx / dfx;

            // Ensure x stays within bounds
            if (x < lower || x > upper) {
                throw new ArithmeticException("Iteration went out of bounds");
            }
        }

        throw new ArithmeticException("Method failed to converge within max iterations");
    }
}
