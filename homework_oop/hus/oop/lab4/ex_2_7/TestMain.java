package hus.oop.lab4.ex_2_7;

public class TestMain {
    public static void main(String[] args) {
        // Test 1: Create MyLine using coordinates constructor
        System.out.println("Test 1: Coordinates Constructor");
        MyLine line1 = new MyLine(0, 0, 3, 4);
        System.out.println("Line: " + line1);
        System.out.println("Begin point: " + line1.getBegin());
        System.out.println("End point: " + line1.getEnd());
        System.out.println("Length: " + line1.getLength()); // Expected: 5.0
        System.out.println("Gradient (radians): " + line1.getGradient()); // Expected: ≈ 0.9273 (53 degrees)
        System.out.println("Gradient (degrees): " + Math.toDegrees(line1.getGradient()));
        System.out.println();

        // Test 2: Create MyLine using MyPoint constructor
        System.out.println("Test 2: MyPoint Constructor");
        MyPoint begin = new MyPoint(1, 2);
        MyPoint end = new MyPoint(4, 6);
        MyLine line2 = new MyLine(begin, end);
        System.out.println("Line: " + line2);
        System.out.println("Begin X: " + line2.getBeginX() + ", Begin Y: " + line2.getBeginY());
        System.out.println("End X: " + line2.getEndX() + ", End Y: " + line2.getEndY());
        System.out.println("Length: " + line2.getLength()); // Expected: 5.0
        System.out.println("Gradient (radians): " + line2.getGradient()); // Expected: ≈ 0.9273
        System.out.println();

        // Test 3: Test setters and getters for coordinates
        System.out.println("Test 3: Setters and Getters for Coordinates");
        line2.setBeginX(0);
        line2.setEndY(0);
        System.out.println("After modification: " + line2);
        System.out.println("Begin XY: " + arrayToString(line2.getBeginXY()));
        System.out.println("End XY: " + arrayToString(line2.getEndXY()));
        System.out.println("Length: " + line2.getLength());
        System.out.println("Gradient (radians): " + line2.getGradient());
        System.out.println();

        // Test 4: Horizontal line
        System.out.println("Test 4: Horizontal Line");
        MyLine horizontalLine = new MyLine(1, 2, 5, 2);
        System.out.println("Line: " + horizontalLine);
        System.out.println("Length: " + horizontalLine.getLength()); // Expected: 4.0
        System.out.println("Gradient (radians): " + horizontalLine.getGradient()); // Expected: 0.0
        System.out.println();

        // Test 5: Vertical line
        System.out.println("Test 5: Vertical Line");
        MyLine verticalLine = new MyLine(3, 1, 3, 4);
        System.out.println("Line: " + verticalLine);
        System.out.println("Length: " + verticalLine.getLength()); // Expected: 3.0
        System.out.println("Gradient (radians): " + verticalLine.getGradient()); // Expected: π/2 ≈ 1.5708
        System.out.println();

        // Test 6: Coincident points (zero length)
        System.out.println("Test 6: Coincident Points");
        MyLine zeroLine = new MyLine(2, 2, 2, 2);
        System.out.println("Line: " + zeroLine);
        System.out.println("Length: " + zeroLine.getLength()); // Expected: 0.0
        System.out.println("Gradient (radians): " + zeroLine.getGradient()); // Expected: 0.0 (undefined, but atan2 returns 0)
        System.out.println();

        // Test 7: Modify using setBegin and setEnd
        System.out.println("Test 7: Modify with setBegin and setEnd");
        MyLine line3 = new MyLine(0, 0, 1, 1);
        line3.setBegin(new MyPoint(2, 3));
        line3.setEnd(new MyPoint(5, 7));
        System.out.println("Line: " + line3);
        System.out.println("Length: " + line3.getLength());
        System.out.println("Gradient (radians): " + line3.getGradient());
    }

    // Helper method to convert int[] to string for printing
    private static String arrayToString(int[] arr) {
        return "(" + arr[0] + ", " + arr[1] + ")";
    }
}