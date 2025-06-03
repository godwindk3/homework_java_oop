package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_MyPolynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIteration;

    public SecantSolver(double tolerance, int maxIteration) {
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
        if (lower == upper) {
            throw new IllegalArgumentException("Lower and upper bounds must be different");
        }

        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        for (int i = 0; i < maxIteration; i++) {
            if (Math.abs(f1) < tolerance) {
                return x1;
            }

            double denominator = f1 - f0;
            if (Math.abs(denominator) < 1e-10) {
                throw new ArithmeticException("Method failed due to near-zero denominator");
            }

            double x2 = x1 - f1 * (x1 - x0) / denominator;
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = polynomial.evaluate(x1);
        }

        throw new ArithmeticException("Method failed to converge within max iterations");
    }
}