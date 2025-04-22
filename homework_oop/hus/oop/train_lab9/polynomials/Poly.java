package hus.oop.train_lab9.polynomials;

public interface Poly {
    int degree();

    Poly derivative();

    double coefficient(int degree);

    double[] coefficients();

}
