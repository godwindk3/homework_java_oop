package hus.oop.lab9.polynomials;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    private final List<Double> coefficients;

    public ListPoly(double[] coeffs) {
        this.coefficients = new ArrayList<>();
        for (double c : coeffs) {
            this.coefficients.add(c);
        }
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public Poly derivative() {
        double[] derived = derive();
        return new ListPoly(derived);
    }

    @Override
    public double coefficient(int degree) {
        return degree < coefficients.size() ? coefficients.get(degree) : 0;
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }
}


