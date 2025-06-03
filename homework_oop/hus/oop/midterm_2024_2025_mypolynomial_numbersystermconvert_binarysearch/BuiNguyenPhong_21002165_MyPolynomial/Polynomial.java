package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_MyPolynomial;

public interface Polynomial {
    double coefficientAt(int index);

    double[] coefficients();

    int degree();

    Polynomial derivative();

    double evaluate(double x);

    void insertAtEnd(double coeff);

    void insertAtPosition(int index, double coeff);

    void insertAtStart(double coeff);

    void set(int index, double coeff);

}
