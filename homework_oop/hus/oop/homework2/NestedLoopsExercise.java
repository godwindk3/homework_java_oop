package hus.oop.homework2;

import java.util.Scanner;

public class NestedLoopsExercise {
    public static void squarePattern(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("# ");
            }
            System.out.println("  ");
        }
    }

    public static void testSquarePattern() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        squarePattern(size);
//        in.close();
    }

    public static void checkerPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row % 2 == 0) {
                    System.out.print(" #");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println("");
        }
    }


    public static void testCheckerPattern() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        checkerPattern(size);
//        in.close();

    }

    public static void timeTable(int n) {
        System.out.print("   * |");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n" + "----" + "-".repeat(n * 4));

        for (int i = 1; i <= n; i++) {
            System.out.printf("%4d |", i);
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println("");
        }
    }

    public static void testTimeTable() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        timeTable(size);
//        in.close();
    }

    public static void triangularPatternA(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row >= col) {
                    System.out.print("# ");
                }
            }
            System.out.println("");
        }
    }

    public static void triangularPatternB(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row <= col) {
                    System.out.print("# ");
                }
            }
            System.out.println("");
        }
    }

    public static void triangularPatternC(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row <= col) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public static void triangularPatternD(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row + col >= n + 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public static void testTriangularPatter() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        System.out.println("A:");
        triangularPatternA(size);
        System.out.println("B:");
        triangularPatternB(size);
        System.out.println("C:");
        triangularPatternC(size);
        System.out.println("D:");
        triangularPatternD(size);
//        in.close();
    }

    public static void boxPatternA(int n) {
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                if (row == 1 || row == (n - 1) || col == 1 || col == (n - 1)) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public static void boxPatternB(int n) {
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                if (row == 1 || row == (n - 1) || row == col) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public static void boxPatternC(int n) {
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                if (row == 1 || row == (n - 1) || row + col == n) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("");
        }
    }

    public static void boxPatternD(int n) {
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                if (row == 1 || row == (n - 1) || row + col == n || row == col) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("");
        }
    }

    public static void testBoxPattern() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        System.out.println("A:");
        boxPatternA(size);
        System.out.println("B:");
        boxPatternB(size);
        System.out.println("C:");
        boxPatternC(size);
        System.out.println("D:");
        boxPatternD(size);

//        in.close();

    }

    public static void hillPatternA(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= 2 * n - 1; col++) {
                if ((row + col >= n + 1) && (row >= col - n + 1)) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }

    }

    public static void hillPatternB(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= 2 * n - 1; col++) {
                if ((row + col >= 2 * row) && (row + col <= 2 * n)) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");

        }
    }

    public static void hillPatternC(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            for (int col = 1; col <= 2 * n - 1; col++) {
                if (row <= n) {
                    if ((col + row >= n + 1) && (row >= col - n + 1)) {
                        System.out.print("# ");
                    } else {
                        System.out.print("  ");
                    }

                } else {
                    if ((row - col <= n - 1) && (row + col <= 3 * n - 1)) {
                        System.out.print("# ");
                    } else {
                        System.out.print("  ");
                    }
                }

            }
            System.out.println("");
        }
    }

    public static void hillPatternD(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            for (int col = 1; col <= 2 * n - 1; col++) {
                if (row <= n) {
                    if ((col + row >= n + 2) && (col - row <= n - 2)) {
                        System.out.print("  ");
                    } else {
                        System.out.print("# ");
                    }

                } else {
                    if ((row - col <= n - 2) && (row + col <= 3 * n - 2)) {
                        System.out.print("  ");
                    } else {
                        System.out.print("# ");
                    }
                }

            }
            System.out.println("");
        }
    }

    public static void testHillPattern() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = in.nextInt();
        System.out.println("A:");
        hillPatternA(size);
        System.out.println("B:");
        hillPatternB(size);
        System.out.println("C:");
        hillPatternC(size);
        System.out.println("D:");
        hillPatternD(size);

        in.close();

    }

    public static void main(String[] args) {
        testSquarePattern();
        testCheckerPattern();
        testTimeTable();
        testTriangularPatter();
        testBoxPattern();
        testHillPattern();
    }

}
