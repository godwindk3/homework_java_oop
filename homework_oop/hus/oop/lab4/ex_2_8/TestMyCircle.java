package hus.oop.lab4.ex_2_8;

public class TestMyCircle {
    public static void main(String[] args) {
        // Test 1: Default constructor
        System.out.println("Test 1: Default Constructor");
        MyCircle circle1 = new MyCircle();
        System.out.println("Circle: " + circle1);
        System.out.println("Center: " + circle1.getCenter());
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea()); // Expected: ≈ 3.14159
        System.out.println("Circumference: " + circle1.getCircumference()); // Expected: ≈ 6.28318
        System.out.println();

        // Test 2: Constructor with coordinates
        System.out.println("Test 2: Constructor with Coordinates");
        MyCircle circle2 = new MyCircle(1, 2, 3);
        System.out.println("Circle: " + circle2);
        System.out.println("Center X: " + circle2.getCenterX());
        System.out.println("Center Y: " + circle2.getCenterY());
        System.out.println("Center XY: " + arrayToString(circle2.getCenterXY()));
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea()); // Expected: ≈ 28.27433
        System.out.println();

        // Test 3: Constructor with MyPoint
        System.out.println("Test 3: Constructor with MyPoint");
        MyPoint center = new MyPoint(4, 5);
        MyCircle circle3 = new MyCircle(center, 2);
        System.out.println("Circle: " + circle3);
        System.out.println("Center: " + circle3.getCenter());
        System.out.println("Radius: " + circle3.getRadius());
        System.out.println("Circumference: " + circle3.getCircumference()); // Expected: ≈ 12.56637
        System.out.println();

        // Test 4: Setters and Getters
        System.out.println("Test 4: Setters and Getters");
        circle2.setCenterX(0);
        circle2.setCenterY(0);
        circle2.setRadius(5);
        System.out.println("After modification: " + circle2);
        System.out.println("Center XY: " + arrayToString(circle2.getCenterXY()));
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea()); // Expected: ≈ 78.53981
        System.out.println();

        // Test 5: Distance between two circles
        System.out.println("Test 5: Distance between Two Circles");
        MyCircle circle4 = new MyCircle(0, 0, 1);
        MyCircle circle5 = new MyCircle(3, 4, 2);
        System.out.println("Circle 1: " + circle4);
        System.out.println("Circle 2: " + circle5);
        System.out.println("Distance between centers: " + circle4.distance(circle5)); // Expected: 5.0
        System.out.println();

        // Test 6: Modify center using setCenter and setCenterXY
        System.out.println("Test 6: Modify Center");
        MyCircle circle6 = new MyCircle(1, 1, 1);
        circle6.setCenter(new MyPoint(2, 3));
        System.out.println("After setCenter: " + circle6);
        circle6.setCenterXY(4, 5);
        System.out.println("After setCenterXY: " + circle6);
        System.out.println();

        // Test 7: Edge case - Same center, different radius
        System.out.println("Test 7: Circles with Same Center");
        MyCircle circle7 = new MyCircle(2, 2, 3);
        MyCircle circle8 = new MyCircle(2, 2, 5);
        System.out.println("Circle 1: " + circle7);
        System.out.println("Circle 2: " + circle8);
        System.out.println("Distance between centers: " + circle7.distance(circle8)); // Expected: 0.0
        System.out.println();

        // Test 8: Edge case - Null handling (uncomment to test if null checks are added)
        /*
        System.out.println("Test 8: Null Handling");
        try {
            MyCircle circle9 = new MyCircle(null, 1);
            System.out.println(circle9);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        */
    }

    // Helper method to convert int[] to string for printing
    private static String arrayToString(int[] arr) {
        return "(" + arr[0] + ", " + arr[1] + ")";
    }
}