package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.mynumbersystem;

public class ANumber {
    private String numberPresentation;  // Biểu diễn số
    private int radix;                  // Cơ số


    public ANumber(String originalNumber, int radix) {
        /* TODO */
        this.numberPresentation = originalNumber.toUpperCase();
        this.radix = radix;
    }

    public String getNumberPresentation() {
        /* TODO */
        return numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        /* TODO */
        this.numberPresentation = numberPresentation.toUpperCase();
    }

    public int getRadix() {
        /* TODO */
        return radix;
    }

    public void setRadix(int radix) {
        /* TODO */
        this.radix = radix;
    }
}