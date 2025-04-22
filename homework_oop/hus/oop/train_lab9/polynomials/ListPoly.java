package hus.oop.train_lab9.polynomials;

import java.util.ArrayList;
import java.util.List;


public class ListPoly extends AbstractPoly{
    List<Double> coefficients;

    public ListPoly(double[] coeffs) {
        this.coefficients = new ArrayList<>();
        for (double coeff: coeffs) {
            this.coefficients.add(coeff);
        }
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public Poly derivative() {
        return new ListPoly(derive());
    }

    @Override
    public double coefficient(int degree) {
        if (degree < this.coefficients.size()) {
            return this.coefficients.get(degree);
        }
        return 0;
    }

    @Override
    public double[] coefficients() {
        double[] coeffs = new double[this.coefficients.size()];
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = this.coefficients.get(i);
        }
        return coeffs;
    }


}
