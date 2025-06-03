package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_NumberSystemConverter;

public class MyNumber {
    private String numberPresentation;
    private int radix;

    public MyNumber(String numberPresentation, int radix) {
        this.numberPresentation = numberPresentation;
        this.radix = radix;
    }

    public String getNumberPresentation() {
        return numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        this.numberPresentation = numberPresentation;
    }

    public int getRadix() {
        return radix;
    }

    public void setRadix(int radix) {
        this.radix = radix;
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "numberPresentation='" + numberPresentation + '\'' +
                ", radix=" + radix +
                '}';
    }
}
