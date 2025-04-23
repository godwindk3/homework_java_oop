package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_MyPolynomial;

public class PolynomialRootFinding {
    Polynomial poly;
    RootSolver rootSolver;

    public PolynomialRootFinding(Polynomial poly) {
        if (poly == null) {
            throw new IllegalArgumentException("Polynomial cannot be null");
        }
        this.poly = poly;
    }

    public PolynomialRootFinding(Polynomial poly, RootSolver rootSolver) {
        if (poly == null || rootSolver == null) {
            throw new IllegalArgumentException("Polynomial and root solver cannot be null");
        }
        this.poly = poly;
        this.rootSolver = rootSolver;
    }

    public void setPoly(Polynomial poly) {
        if (poly == null) {
            throw new IllegalArgumentException("Polynomial cannot be null");
        }
        this.poly = poly;
    }

    public void setRootSolver(RootSolver rootSolver) {
        if (rootSolver == null) {
            throw new IllegalArgumentException("Root solver cannot be null");
        }
        this.rootSolver = rootSolver;
    }

    public double solve(double lower, double upper) {
        if (rootSolver == null) {
            throw new IllegalStateException("Root solver not set");
        }
        if (poly == null) {
            throw new IllegalStateException("Polynomial not set");
        }
        return rootSolver.solve(poly, lower, upper);
    }
}