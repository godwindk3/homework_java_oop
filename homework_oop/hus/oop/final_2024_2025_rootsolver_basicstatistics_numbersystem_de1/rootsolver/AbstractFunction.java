package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.rootsolver;

public interface AbstractFunction {
    /*
     * Tính giá trị của hàm tại điểm x
     */
    double evaluate(double x);

    /*
     * Tính giá trị của đạo hàm tại điểm x
     */
    double derivative(double x);
}
