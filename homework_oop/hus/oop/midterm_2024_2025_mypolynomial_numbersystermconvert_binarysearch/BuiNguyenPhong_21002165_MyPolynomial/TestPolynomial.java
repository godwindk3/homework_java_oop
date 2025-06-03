package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_MyPolynomial;

public class TestPolynomial {
    public static void main(String[] args) {
//    testArrayPolynomial();
//        testListPolynomial();
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        // Test 1: Create polynomial and check toString, degree
        System.out.println("Test 1: Create polynomial and check toString, degree");
        ArrayPolynomial p1 = new ArrayPolynomial();
        p1.insertAtEnd(2);    // 2
        p1.insertAtEnd(3);    // 2 + 3x
        p1.insertAtEnd(0);    // 2 + 3x + 0x^2
        p1.insertAtEnd(4);    // 2 + 3x + 0x^2 + 4x^3
        System.out.println("p1: " + p1); // Expected: 2 + 3x + 4x^3
        System.out.println("Degree: " + p1.degree()); // Expected: 3
        System.out.println();

        // Test 2: Check coefficientAt
        System.out.println("Test 2: Check coefficientAt");
        System.out.println("Coefficient at index 0: " + p1.coefficientAt(0)); // Expected: 2.0
        System.out.println("Coefficient at index 1: " + p1.coefficientAt(1)); // Expected: 3.0
        System.out.println("Coefficient at index 3: " + p1.coefficientAt(3)); // Expected: 4.0
        try {
            p1.coefficientAt(5); // Should throw exception
            System.out.println("Error: Should throw ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught expected ArrayIndexOutOfBoundsException for index 5");
        }
        System.out.println();

        // Test 3: Check coefficients
        System.out.println("Test 3: Check coefficients");
        double[] coeffs = p1.coefficients();
        System.out.print("Coefficients: ");
        for (double coeff : coeffs) {
            System.out.print(coeff + " ");
        } // Expected: 2.0 3.0 0.0 4.0
        System.out.println();
        System.out.println();

        // Test 4: Check evaluate
        System.out.println("Test 4: Check evaluate");
        System.out.println("Evaluate p1 at x=1: " + p1.evaluate(1)); // Expected: 2 + 3*1 + 0*1^2 + 4*1^3 = 9.0
        System.out.println("Evaluate p1 at x=2: " + p1.evaluate(2)); // Expected: 2 + 3*2 + 0*2^2 + 4*2^3 = 40.0
        System.out.println("Evaluate p1 at x=-1: " + p1.evaluate(-1)); // Expected: 2 + 3*(-1) + 0*(-1)^2 + 4*(-1)^3 = -5.0
        System.out.println();

        // Test 5: Check derivative
        System.out.println("Test 5: Check derivative");
        Polynomial deriv = p1.derivative();
        System.out.println("Derivative of p1: " + deriv); // Expected: 3 + 12x^2
        System.out.println("Degree of derivative: " + deriv.degree()); // Expected: 2
        System.out.println();

        // Test 6: Check insertAtEnd with array expansion
        System.out.println("Test 6: Check insertAtEnd with array expansion");
        ArrayPolynomial p2 = new ArrayPolynomial();
        for (int i = 1; i <= 17; i++) { // Insert 17 coefficients to trigger allocateMore
            p2.insertAtEnd(i);
        }
        System.out.println("p2 degree: " + p2.degree()); // Expected: 16
        System.out.println("Coefficient at index 16: " + p2.coefficientAt(16)); // Expected: 17.0
        System.out.println();

        // Test 7: Check insertAtStart
        System.out.println("Test 7: Check insertAtStart");
        ArrayPolynomial p3 = new ArrayPolynomial();
        p3.insertAtStart(5); // 5
        p3.insertAtStart(4); // 4 + 5x
        System.out.println("p3: " + p3); // Expected: 4 + 5x
        System.out.println();

        // Test 8: Check insertAtPosition
        System.out.println("Test 8: Check insertAtPosition");
        p3.insertAtPosition(1, 6); // 4 + 6x + 5x^2
        System.out.println("p3 after insertAtPosition: " + p3); // Expected: 4 + 6x + 5x^2
        try {
            p3.insertAtPosition(4, 1); // Should throw exception
            System.out.println("Error: Should throw ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught expected ArrayIndexOutOfBoundsException for index 4");
        }
        System.out.println();

        // Test 9: Check set
        System.out.println("Test 9: Check set");
        p3.set(1, 7); // 4 + 7x + 5x^2
        System.out.println("p3 after set: " + p3); // Expected: 4 + 7x + 5x^2
        try {
            p3.set(3, 1); // Should throw exception
            System.out.println("Error: Should throw ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught expected ArrayIndexOutOfBoundsException for index 3");
        }
        System.out.println();

        // Test 10: Check plus
        System.out.println("Test 10: Check plus");
        ArrayPolynomial p4 = new ArrayPolynomial();
        p4.insertAtEnd(1); // 1
        p4.insertAtEnd(2); // 1 + 2x
        ArrayPolynomial sum = p1.plus(p4);
        System.out.println("p1 + p4: " + sum); // Expected: 3 + 5x + 4x^3
        System.out.println();

        // Test 11: Check minus
        System.out.println("Test 11: Check minus");
        ArrayPolynomial diff = p1.minus(p4);
        System.out.println("p1 - p4: " + diff); // Expected: 1 + x + 4x^3
        System.out.println();

        // Test 12: Check multiply
        System.out.println("Test 12: Check multiply");
        ArrayPolynomial prod = p1.multiply(p4);
        System.out.println("p1 * p4: " + prod); // Expected: 2 + 7x + 6x^2 + 8x^3 + 8x^4
        System.out.println();

        // Test 13: Check empty polynomial
        System.out.println("Test 13: Check empty polynomial");
        ArrayPolynomial empty = new ArrayPolynomial();
        System.out.println("Empty polynomial: " + empty); // Expected: 0
        System.out.println("Degree: " + empty.degree()); // Expected: 0
        System.out.println("Evaluate at x=1: " + empty.evaluate(1)); // Expected: 0.0
        System.out.println("Derivative: " + empty.derivative()); // Expected: 0
        System.out.println();

        // Test 14: Check constant polynomial
        System.out.println("Test 14: Check constant polynomial");
        ArrayPolynomial constant = new ArrayPolynomial();
        constant.insertAtEnd(10); // 10
        System.out.println("Constant polynomial: " + constant); // Expected: 10
        System.out.println("Degree: " + constant.degree()); // Expected: 0
        System.out.println("Derivative: " + constant.derivative()); // Expected: 0
        System.out.println();

        // Test 15: Check polynomial with zero coefficients
        System.out.println("Test 15: Check polynomial with zero coefficients");
        ArrayPolynomial zeroPoly = new ArrayPolynomial();
        zeroPoly.insertAtEnd(0); // 0
        zeroPoly.insertAtEnd(0); // 0 + 0x
        System.out.println("Zero polynomial: " + zeroPoly); // Expected: 0
        System.out.println("Degree: " + zeroPoly.degree()); // Expected: 0
        System.out.println();

    }

    public static void testListPolynomial() {
        // Test 1: Create polynomial and check toString, degree
        System.out.println("Test 1: Create polynomial and check toString, degree");
        ListPolynomial p1 = new ListPolynomial();
        p1.insertAtEnd(2);    // 2
        p1.insertAtEnd(3);    // 2 + 3x
        p1.insertAtEnd(0);    // 2 + 3x + 0x^2
        p1.insertAtEnd(4);    // 2 + 3x + 0x^2 + 4x^3
        System.out.println("p1: " + p1); // Expected: 2 + 3x + 4x^3
        System.out.println("Degree: " + p1.degree()); // Expected: 3
        System.out.println();

        // Test 2: Check derivative
        System.out.println("Test 2: Check derivative");
        Polynomial deriv = p1.derivative();
        System.out.println("Derivative of p1: " + deriv); // Expected: 3 + 8x^2
        System.out.println();

        // Test 3: Check multiply
        System.out.println("Test 3: Check multiply");
        ListPolynomial p2 = new ListPolynomial();
        p2.insertAtEnd(1); // 1
        p2.insertAtEnd(2); // 1 + 2x
        ListPolynomial prod = p1.multiply(p2);
        System.out.println("p1 * p2: " + prod); // Expected: 2 + 7x + 6x^2 + 8x^3 + 8x^4
        System.out.println();

        // Test 4: Check empty polynomial
        System.out.println("Test 4: Check empty polynomial");
        ListPolynomial empty = new ListPolynomial();
        System.out.println("Empty polynomial: " + empty); // Expected: 0
        System.out.println("Degree: " + empty.degree()); // Expected: 0
        System.out.println("Derivative: " + empty.derivative()); // Expected: 0
        System.out.println();
    }

    public static void testRootSolver() {
        // Create a polynomial: x^2 - 4 (roots at x = -2 and x = 2)
        ArrayPolynomial poly = new ArrayPolynomial();
        poly.insertAtEnd(-4); // -4
        poly.insertAtEnd(0);  // 0x
        poly.insertAtEnd(1);  // x^2

        // Test BisectionSolver
        System.out.println("Test BisectionSolver");
        RootSolver bisection = new BisectionSolver(1e-6, 100);
        PolynomialRootFinding finder = new PolynomialRootFinding(poly, bisection);
        try {
            double root = finder.solve(1, 3); // Should find root near 2
            System.out.println("Root found by Bisection: " + root);
        } catch (Exception e) {
            System.out.println("Bisection error: " + e.getMessage());
        }
        System.out.println();

        // Test SecantSolver
        System.out.println("Test SecantSolver");
        RootSolver secant = new SecantSolver(1e-6, 100);
        finder.setRootSolver(secant);
        try {
            double root = finder.solve(1, 3); // Should find root near 2
            System.out.println("Root found by Secant: " + root);
        } catch (Exception e) {
            System.out.println("Secant error: " + e.getMessage());
        }
        System.out.println();

        // Test NewtonRaphsonSolver
        System.out.println("Test NewtonRaphsonSolver");
        RootSolver newton = new NewtonRaphsonSolver(1e-6, 100);
        finder.setRootSolver(newton);
        try {
            double root = finder.solve(1, 3); // Should find root near 2
            System.out.println("Root found by Newton-Raphson: " + root);
        } catch (Exception e) {
            System.out.println("Newton-Raphson error: " + e.getMessage());
        }

    }
}
