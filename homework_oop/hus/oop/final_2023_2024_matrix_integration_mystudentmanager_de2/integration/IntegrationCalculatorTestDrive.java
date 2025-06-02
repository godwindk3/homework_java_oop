package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.integration;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         TODO

         - Viết chương trình test các chức năng của đa thức và các phương pháp tính tích phân.

         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        PrintStream out = new PrintStream("BuiNguyenPhong_21002165_Integration.txt");
        System.setOut(out);

        testPolynomial();
        testIntegrationCalculator();

        out.close();
    }

    public static void testPolynomial() {
        /*
         TODO

         - Tạo ra các đá thức kiểu ArrayPolynomial và ListPolynomial.
         - Viết chương trình test các chức năng của đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - In kết quả ra terminal mỗi lần thực hiện các chức năng.
         */
        System.out.println("===== TEST ARRAY POLYNOMIAL =====");
        ArrayPolynomial p1 = new ArrayPolynomial();
        p1.insertAtEnd(1.0).insertAtEnd(0.0).insertAtEnd(2.0); // 1 + 0x + 2x^2
        System.out.println("P1 = " + p1);

        ArrayPolynomial p2 = new ArrayPolynomial();
        p2.insertAtStart(3.0).insertAtEnd(-1.0); // 3 - x
        System.out.println("P2 = " + p2);

        System.out.println("P1 + P2 = " + p1.plus(p2));
        System.out.println("P1 - P2 = " + p1.minus(p2));
        System.out.println("P1 * P2 = " + p1.multiply(p2));
        System.out.println("P1'(x) = " + p1.derivative());
        System.out.println("P1(2.0) = " + p1.evaluate(2.0));

        System.out.println("===== TEST LIST POLYNOMIAL =====");
        ListPolynomial q1 = new ListPolynomial();
        q1.insertAtEnd(2.0).insertAtEnd(1.0).insertAtEnd(4.0); // 2 + x + 4x^2
        System.out.println("Q1 = " + q1);

        ListPolynomial q2 = new ListPolynomial();
        q2.insertAtStart(5.0).insertAtEnd(2.0); // 5 + 2x
        System.out.println("Q2 = " + q2);

        System.out.println("Q1 + Q2 = " + q1.plus(q2));
        System.out.println("Q1 - Q2 = " + q1.minus(q2));
        System.out.println("Q1 * Q2 = " + q1.multiply(q2));
        System.out.println("Q1'(x) = " + q1.derivative());
        System.out.println("Q1(3.0) = " + q1.evaluate(3.0));
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        System.out.println("\n===== TEST INTEGRATION CALCULATOR =====");
        // Tạo đa thức f(x) = 1 + 2x + 3x^2
        ArrayPolynomial p = new ArrayPolynomial();
        p.insertAtEnd(1.0).insertAtEnd(2.0).insertAtEnd(3.0);

        // Midpoint rule
        IntegrationCalculator calc = new IntegrationCalculator(new MidpointRule(1e-6, 20), p);
        double resMid = calc.integrate(0.0, 1.0);
        System.out.printf("MidpointRule ∫(1 + 2x + 3x^2) từ 0 đến 1 = %.6f%n", resMid);

        // Trapezoid rule
        calc.setIntegrator(new TrapezoidRule(1e-6, 20));
        double resTrap = calc.integrate(0.0, 1.0);
        System.out.printf("TrapezoidRule ∫(1 + 2x + 3x^2) từ 0 đến 1 = %.6f%n", resTrap);

        // Simpson rule
        calc.setIntegrator(new SimpsonRule(1e-6, 20));
        double resSimp = calc.integrate(0.0, 1.0);
        System.out.printf("SimpsonRule ∫(1 + 2x + 3x^2) từ 0 đến 1 = %.6f%n", resSimp);
    }
}
