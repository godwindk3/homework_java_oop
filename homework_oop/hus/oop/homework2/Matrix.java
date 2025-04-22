package hus.oop.homework2;

public class Matrix {
    public static void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public static void print(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean haveSameDimension(int[][] matrix1, int[][] matrix2) {
        if ((matrix1.length == matrix2.length) && (matrix1[0].length == matrix2[0].length)) {
            return true;
        }
        return false;

    }

    public static boolean haveSameDimension(double[][] matrix1, double[][] matrix2) {
        if ((matrix1.length == matrix2.length) && (matrix1[0].length == matrix2[0].length)) {
            return true;
        }
        return false;

    }

    public static int[][] add(int[][] matrix1, int[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            int[][] matrix = new int[matrix1.length][matrix1[0].length];
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[0].length; col++) {
                    matrix[row][col] = matrix1[row][col] + matrix2[row][col];
                }
            }
            return matrix;
        } else {
            return null;
        }
    }

    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            double[][] matrix = new double[matrix1.length][matrix1[0].length];
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[0].length; col++) {
                    matrix[row][col] = matrix1[row][col] + matrix2[row][col];
                }
            }
            return matrix;
        } else {
            return null;
        }

    }

    public static int[][] subtract(int[][] matrix1, int[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            int[][] matrix = new int[matrix1.length][matrix1[0].length];
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[0].length; col++) {
                    matrix[row][col] = matrix1[row][col] - matrix2[row][col];
                }
            }
            return matrix;
        } else {
            return null;
        }

    }

    public static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            double[][] matrix = new double[matrix1.length][matrix1[0].length];
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[0].length; col++) {
                    matrix[row][col] = matrix1[row][col] - matrix2[row][col];
                }
            }
            return matrix;
        } else {
            return null;
        }

    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            return null;
        } else {
            int[][] matrix = new int[matrix1.length][matrix2[0].length];
            int temp = 0;
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    for (int k = 0; k < matrix2[0].length; k++) {
                        matrix[i][k] += matrix1[i][j] * matrix2[j][k];
                    }
                }
            }
            return matrix;
        }
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            return null;
        } else {
            double[][] matrix = new double[matrix1.length][matrix2[0].length];
            int temp = 0;
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    for (int k = 0; k < matrix2[0].length; k++) {
                        matrix[i][k] += matrix1[i][j] * matrix2[j][k];
                    }
                }
            }
            return matrix;
        }
    }


    public static void main(String[] args) {
        int[][] matrix1 = {{3, 3, 1}, {2, 3, 3}};
        int[][] matrix2 = {{3, 1}, {2, 2}, {1, 3}};
        print(multiply(matrix1, matrix2));

    }
}
