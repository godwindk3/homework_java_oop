package hus.oop.final_2023_2024_fraction_basicstatistics_integration.integration;

import java.util.Random;
public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
           - Chạy demo các hàm test.
           - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
             (ví dụ, NguyenVanA_123456_Integration.txt)
           - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        System.out.println("=== INTEGRATION CALCULATOR TEST DRIVE ===\n");

        // Chạy các test
        testArrayPolynomial();
        System.out.println("\n" + "=".repeat(80) + "\n");

        testListPolynomial();
        System.out.println("\n" + "=".repeat(80) + "\n");

        testIntegrationCalculator();

        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL TESTS COMPLETED SUCCESSFULLY!");
        System.out.println("=".repeat(80));
    }

    public static void testArrayPolynomial() {
        /*
           - Tạo ra các đa thức MyArrayPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh ngẫu nhiên trong đoạn [1, 10],
             và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết chương trình test các chức năng của MyArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
             sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
             giá trị của x).
         */
        System.out.println("TESTING MyArrayPolynomial");
        System.out.println("=".repeat(50));

        Random random = new Random();

        // Tạo đa thức 1
        int degree1 = random.nextInt(10) + 1; // [1, 10]
        MyArrayPolynomial poly1 = new MyArrayPolynomial();

        System.out.println("Creating polynomial 1 with degree " + degree1);
        for (int i = 0; i <= degree1; i++) {
            double coeff = random.nextInt(10) + 1; // [1, 10]
            poly1.append(coeff);
        }
        System.out.println("Polynomial 1: " + poly1.toString());

        // Tạo đa thức 2
        int degree2 = random.nextInt(10) + 1; // [1, 10]
        MyArrayPolynomial poly2 = new MyArrayPolynomial();

        System.out.println("\nCreating polynomial 2 with degree " + degree2);
        for (int i = 0; i <= degree2; i++) {
            double coeff = random.nextInt(10) + 1; // [1, 10]
            poly2.append(coeff);
        }
        System.out.println("Polynomial 2: " + poly2.toString());

        // Test các chức năng
        System.out.println("\n--- Testing Operations ---");

        // Test insert
        System.out.println("1. Testing insert operation:");
        MyArrayPolynomial poly1Copy = new MyArrayPolynomial();
        for (double coeff : poly1.coefficients()) {
            poly1Copy.append(coeff);
        }
        poly1Copy.insert(5.0, 1);
        System.out.println("   After inserting 5.0 at index 1: " + poly1Copy.toString());

        // Test set
        System.out.println("2. Testing set operation:");
        poly1Copy.set(99.0, 0);
        System.out.println("   After setting coefficient at index 0 to 99.0: " + poly1Copy.toString());

        // Test evaluate
        double x = 2.0;
        System.out.println("3. Testing evaluate operation:");
        System.out.printf("   poly1(%g) = %g\n", x, poly1.evaluate(x));
        System.out.printf("   poly2(%g) = %g\n", x, poly2.evaluate(x));

        // Test derivative
        System.out.println("4. Testing derivative operation:");
        MyPolynomial derivative1 = poly1.derivative();
        System.out.println("   Derivative of poly1: " + derivative1.toString());

        // Test arithmetic operations (tạo copy để không thay đổi poly gốc)
        System.out.println("5. Testing arithmetic operations:");

        // Addition
        MyArrayPolynomial addResult = new MyArrayPolynomial();
        for (double coeff : poly1.coefficients()) {
            addResult.append(coeff);
        }
        addResult.plus(poly2);
        System.out.println("   poly1 + poly2 = " + addResult.toString());

        // Subtraction
        MyArrayPolynomial subResult = new MyArrayPolynomial();
        for (double coeff : poly1.coefficients()) {
            subResult.append(coeff);
        }
        subResult.minus(poly2);
        System.out.println("   poly1 - poly2 = " + subResult.toString());

        // Multiplication
        MyArrayPolynomial mulResult = new MyArrayPolynomial();
        for (double coeff : poly1.coefficients()) {
            mulResult.append(coeff);
        }
        mulResult.multiply(poly2);
        System.out.println("   poly1 * poly2 = " + mulResult.toString());
    }

    public static void testListPolynomial() {
        /*
           - Tạo ra các đa thức MyListPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh ngẫu nhiên trong đoạn [1, 10],
             và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết chương trình test các chức năng của MyListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
             sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
             giá trị của x).
         */
        System.out.println("TESTING MyListPolynomial");
        System.out.println("=".repeat(50));

        Random random = new Random();

        // Tạo đa thức 1
        int degree1 = random.nextInt(10) + 1; // [1, 10]
        MyListPolynomial poly1 = new MyListPolynomial();

        System.out.println("Creating polynomial 1 with degree " + degree1);
        for (int i = 0; i <= degree1; i++) {
            double coeff = random.nextInt(10) + 1; // [1, 10]
            poly1.append(coeff);
        }
        System.out.println("Polynomial 1: " + poly1.toString());

        // Tạo đa thức 2
        int degree2 = random.nextInt(10) + 1; // [1, 10]
        MyListPolynomial poly2 = new MyListPolynomial();

        System.out.println("\nCreating polynomial 2 with degree " + degree2);
        for (int i = 0; i <= degree2; i++) {
            double coeff = random.nextInt(10) + 1; // [1, 10]
            poly2.append(coeff);
        }
        System.out.println("Polynomial 2: " + poly2.toString());

        // Test các chức năng
        System.out.println("\n--- Testing Operations ---");

        // Test insert
        System.out.println("1. Testing insert operation:");
        MyListPolynomial poly1Copy = new MyListPolynomial();
        for (double coeff : poly1.coefficients()) {
            poly1Copy.append(coeff);
        }
        poly1Copy.insert(5.0, 1);
        System.out.println("   After inserting 5.0 at index 1: " + poly1Copy.toString());

        // Test set
        System.out.println("2. Testing set operation:");
        poly1Copy.set(99.0, 0);
        System.out.println("   After setting coefficient at index 0 to 99.0: " + poly1Copy.toString());

        // Test evaluate
        double x = 2.0;
        System.out.println("3. Testing evaluate operation:");
        System.out.printf("   poly1(%g) = %g\n", x, poly1.evaluate(x));
        System.out.printf("   poly2(%g) = %g\n", x, poly2.evaluate(x));

        // Test derivative
        System.out.println("4. Testing derivative operation:");
        MyPolynomial derivative1 = poly1.derivative();
        System.out.println("   Derivative of poly1: " + derivative1.toString());

        // Test arithmetic operations (tạo copy để không thay đổi poly gốc)
        System.out.println("5. Testing arithmetic operations:");

        // Addition
        MyListPolynomial addResult = new MyListPolynomial();
        for (double coeff : poly1.coefficients()) {
            addResult.append(coeff);
        }
        addResult.plus(poly2);
        System.out.println("   poly1 + poly2 = " + addResult.toString());

        // Subtraction
        MyListPolynomial subResult = new MyListPolynomial();
        for (double coeff : poly1.coefficients()) {
            subResult.append(coeff);
        }
        subResult.minus(poly2);
        System.out.println("   poly1 - poly2 = " + subResult.toString());

        // Multiplication
        MyListPolynomial mulResult = new MyListPolynomial();
        for (double coeff : poly1.coefficients()) {
            mulResult.append(coeff);
        }
        mulResult.multiply(poly2);
        System.out.println("   poly1 * poly2 = " + mulResult.toString());
    }

    public static void testIntegrationCalculator() {
        /*
           - Tạo ra các đa thức MyArrayPolynomial và MyListPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh
             ngẫu nhiên trong đoạn [1, 10], và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho
             (MidpointMethod, TrapezoidMethod, SimpsonMethod) sử dụng IntegrationCalculator. Các phương pháp tính tích phân
             có thể thay đổi ở thời gian chạy chương trình.
           - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        System.out.println("TESTING IntegrationCalculator");
        System.out.println("=".repeat(50));

        Random random = new Random();

        // Tạo đa thức MyArrayPolynomial
        int degree1 = random.nextInt(5) + 2; // [2, 6] để tích phân có ý nghĩa
        MyArrayPolynomial arrayPoly = new MyArrayPolynomial();

        System.out.println("Creating MyArrayPolynomial with degree " + degree1);
        for (int i = 0; i <= degree1; i++) {
            double coeff = random.nextInt(5) + 1; // [1, 5] để số không quá lớn
            arrayPoly.append(coeff);
        }
        System.out.println("Array Polynomial: " + arrayPoly.toString());

        // Tạo đa thức MyListPolynomial
        int degree2 = random.nextInt(5) + 2; // [2, 6]
        MyListPolynomial listPoly = new MyListPolynomial();

        System.out.println("\nCreating MyListPolynomial with degree " + degree2);
        for (int i = 0; i <= degree2; i++) {
            double coeff = random.nextInt(5) + 1; // [1, 5]
            listPoly.append(coeff);
        }
        System.out.println("List Polynomial: " + listPoly.toString());

        // Thiết lập các phương pháp tích phân
        double precision = 1e-6;
        int maxIterations = 20;

        Integrator midpointMethod = new MidpointMethod(precision, maxIterations);
        Integrator trapezoidMethod = new TrapezoidMethod(precision, maxIterations);
        Integrator simpsonMethod = new SimpsonMethod(precision, maxIterations);

        // Khoảng tích phân
        double lower = 0.0;
        double upper = 2.0;

        System.out.println("\n--- Integration Results ---");
        System.out.printf("Integration interval: [%g, %g]\n", lower, upper);
        System.out.printf("Precision: %g, Max iterations: %d\n\n", precision, maxIterations);

        // Test với MyArrayPolynomial
        System.out.println("1. Testing with MyArrayPolynomial:");
        System.out.println("   Polynomial: " + arrayPoly.toString());

        IntegrationCalculator calculator = new IntegrationCalculator(arrayPoly);

        // Midpoint Method
        calculator.setIntegrator(midpointMethod);
        double midpointResult = calculator.integrate(lower, upper);
        System.out.printf("   Midpoint Method result: %g\n", midpointResult);

        // Trapezoid Method
        calculator.setIntegrator(trapezoidMethod);
        double trapezoidResult = calculator.integrate(lower, upper);
        System.out.printf("   Trapezoid Method result: %g\n", trapezoidResult);

        // Simpson Method
        calculator.setIntegrator(simpsonMethod);
        double simpsonResult = calculator.integrate(lower, upper);
        System.out.printf("   Simpson Method result: %g\n", simpsonResult);

        // Test với MyListPolynomial
        System.out.println("\n2. Testing with MyListPolynomial:");
        System.out.println("   Polynomial: " + listPoly.toString());

        calculator.setPolynomial(listPoly);

        // Midpoint Method
        calculator.setIntegrator(midpointMethod);
        midpointResult = calculator.integrate(lower, upper);
        System.out.printf("   Midpoint Method result: %g\n", midpointResult);

        // Trapezoid Method
        calculator.setIntegrator(trapezoidMethod);
        trapezoidResult = calculator.integrate(lower, upper);
        System.out.printf("   Trapezoid Method result: %g\n", trapezoidResult);

        // Simpson Method
        calculator.setIntegrator(simpsonMethod);
        simpsonResult = calculator.integrate(lower, upper);
        System.out.printf("   Simpson Method result: %g\n", simpsonResult);

        // Test thay đổi phương pháp tại runtime
        System.out.println("\n3. Testing runtime method switching:");

        // Tạo đa thức đơn giản để dễ kiểm tra: f(x) = x^2
        MyArrayPolynomial simplePoly = new MyArrayPolynomial();
        simplePoly.append(0).append(0).append(1); // 0 + 0x + 1x^2 = x^2

        System.out.println("   Simple polynomial: " + simplePoly.toString());
        System.out.printf("   Analytical result for x^2 from %g to %g: %g\n",
                lower, upper, (Math.pow(upper, 3) - Math.pow(lower, 3)) / 3.0);

        calculator.setPolynomial(simplePoly);

        // Test với các phương pháp khác nhau
        String[] methodNames = {"Midpoint", "Trapezoid", "Simpson"};
        Integrator[] methods = {midpointMethod, trapezoidMethod, simpsonMethod};

        for (int i = 0; i < methods.length; i++) {
            calculator.setIntegrator(methods[i]);
            double result = calculator.integrate(lower, upper);
            System.out.printf("   %s Method: %g\n", methodNames[i], result);
        }
    }
}
