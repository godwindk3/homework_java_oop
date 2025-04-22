package hus.oop.lab9.polynomials;

public class ArrayPoly extends AbstractPoly {
    private final double[] coefficients;

    public ArrayPoly(double[] coefficients) {
        this.coefficients = coefficients.clone();
    }

    @Override
    public int degree() {
        return coefficients.length - 1;
    }

    @Override
    public Poly derivative() {
        return new ArrayPoly(derive());
    }

    @Override
    public double coefficient(int degree) {
        if (degree < coefficients.length) {
            return coefficients[degree];
        } else {
            return 0;
        }
    }

    @Override
    public double[] coefficients() {
        return coefficients.clone();
    }
}

