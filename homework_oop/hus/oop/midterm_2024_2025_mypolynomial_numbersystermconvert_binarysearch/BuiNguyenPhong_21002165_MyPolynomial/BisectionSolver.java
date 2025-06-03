package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_MyPolynomial;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIteration;

    public BisectionSolver(double tolerance, int maxIteration) {
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
        if (lower >= upper) {
            throw new IllegalArgumentException("Lower bound must be less than upper bound");
        }

        double fa = polynomial.evaluate(lower);
        double fb = polynomial.evaluate(upper);

        if (fa * fb >= 0) {
            throw new IllegalArgumentException("Function values at bounds must have opposite signs");
        }

        double mid;
        for (int i = 0; i < maxIteration; i++) {
            mid = (lower + upper) / 2;
            double fm = polynomial.evaluate(mid);

            if (Math.abs(fm) < tolerance || (upper - lower) / 2 < tolerance) {
                return mid;
            }

            if (fa * fm < 0) {
                upper = mid;
                fb = fm;
            } else {
                lower = mid;
                fa = fm;
            }
        }

        throw new ArithmeticException("Method failed to converge within max iterations");
    }
}
