package hus.oop.final_2022_2023_matrix_integration_studentmanager.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        // Ví dụ test ArrayPolynomial
        testArrayPolynomial();

        // Ví dụ test ListPolynomial
        testListPolynomial();

        // Ví dụ test IntegrationCalculator
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        System.out.println("=== Test ArrayPolynomial ===");
        ArrayPolynomial p1 = new ArrayPolynomial();
        // p1 = 2 + 3x + 0x^2 + 5x^3
        p1.append(2).append(3).append(0).append(5);
        System.out.println("p1 ban dau: " + p1);

        // test set
        p1.set(4, 2); // p1 = 2 + 3x + 4x^2 + 5x^3
        System.out.println("sau set(4,2): " + p1);

        // test insert
        p1.insert(1, 1);
        // p1 = 2 + 1x + 3x^1 + 4x^2 + 5x^3
        System.out.println("sau insert(1,1): " + p1);

        // test plus
        ArrayPolynomial p2 = new ArrayPolynomial();
        p2.append(1).append(1).append(1); // p2 = 1 + 1x + 1x^2
        p1.plus(p2);
        System.out.println("p1 + p2: " + p1);

        // test minus: (p1 hiện tại) - p2
        p1.minus(p2);
        System.out.println("p1 - p2: " + p1);

        // test multiply
        ArrayPolynomial p3 = new ArrayPolynomial();
        p3.append(1).append(2); // p3 = 1 + 2x
        p1.multiply(p3);
        System.out.println("p1 * p3: " + p1);

        // test evaluate
        double v = p1.evaluate(2.0);
        System.out.println("p1(2.0) = " + v);

        // test derivative
        Polynomial dp1 = p1.derivative();
        System.out.println("p1' = " + dp1);
        System.out.println();
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        System.out.println("=== Test ListPolynomial ===");
        ListPolynomial q1 = new ListPolynomial();
        // q1 = 5 + 0x + 2x^2
        q1.append(5).append(0).append(2);
        System.out.println("q1 ban dau: " + q1);

        // test set
        q1.set(3, 1); // q1 = 5 + 3x + 2x^2
        System.out.println("sau set(3,1): " + q1);

        // test insert
        q1.insert(1, 0); // q1 = 1 + 5 + 3x + 2x^2
        System.out.println("sau insert(1,0): " + q1);

        // test plus
        ListPolynomial q2 = new ListPolynomial();
        q2.append(1).append(1).append(1).append(1); // q2 = 1 + x + x^2 + x^3
        q1.plus(q2);
        System.out.println("q1 + q2: " + q1);

        // test minus
        q1.minus(q2);
        System.out.println("q1 - q2: " + q1);

        // test multiply
        ListPolynomial q3 = new ListPolynomial();
        q3.append(2).append(1); // q3 = 2 + x
        q1.multiply(q3);
        System.out.println("q1 * q3: " + q1);

        // test evaluate
        double w = q1.evaluate(1.5);
        System.out.println("q1(1.5) = " + w);

        // test derivative
        Polynomial dq1 = q1.derivative();
        System.out.println("q1' = " + dq1);
        System.out.println();
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        System.out.println("=== Test IntegrationCalculator ===");
        // Định nghĩa p(x) = x^2 + 2x + 1  => tích phân từ 0 đến 2 = ∫(0->2) (x^2+2x+1)dx = [x^3/3 + x^2 + x]_0^2 = 8/3 + 4 + 2 = 8/3 + 6 = 8/3 + 18/3 = 26/3 ≈ 8.6667
        ArrayPolynomial poly = new ArrayPolynomial();
        poly.append(1).append(2).append(1); // p(x) = 1 + 2x + 1x^2

        double lower = 0.0, upper = 2.0;
        double eps = 1e-6;
        int maxIter = 20;

        // MidpointRule
        IntegrationCalculator calcMid = new IntegrationCalculator(new MidpointRule(eps, maxIter), poly);
        double resMid = calcMid.integrate(lower, upper);
        System.out.printf("MidpointRule  : ∫ p(x)dx từ %.1f đến %.1f = %.6f (kỳ vọng ~8.666667)%n", lower, upper, resMid);

        // TrapezoidRule
        IntegrationCalculator calcTrap = new IntegrationCalculator(new TrapezoidRule(eps, maxIter), poly);
        double resTrap = calcTrap.integrate(lower, upper);
        System.out.printf("TrapezoidRule : ∫ p(x)dx từ %.1f đến %.1f = %.6f (kỳ vọng ~8.666667)%n", lower, upper, resTrap);

        // SimpsonRule
        IntegrationCalculator calcSimp = new IntegrationCalculator(new SimpsonRule(eps, maxIter), poly);
        double resSimp = calcSimp.integrate(lower, upper);
        System.out.printf("SimpsonRule   : ∫ p(x)dx từ %.1f đến %.1f = %.6f (kỳ vọng ~8.666667)%n", lower, upper, resSimp);

        System.out.println();
    }
}
