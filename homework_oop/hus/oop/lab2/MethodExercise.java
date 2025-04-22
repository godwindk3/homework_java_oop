package hus.oop.lab2;

import java.util.Scanner;

public class MethodExercise {
    public static int exponent(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        int product = 1;
        for (int i = 0; i < exp; i++) {
            product *= base;
        }
        return product;
    }

    public static void testExponent() {
        int base;
        int exp;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the base: ");
        base = in.nextInt();

        System.out.print("Enter the exponent: ");
        exp = in.nextInt();
        System.out.print(base + " raises to the power of " + exp + " is: " + exponent(base, exp));
        in.close();
    }

    public static boolean hasEight(int number) {
        int temp;
        while (number > 0) {
            temp = number % 10;
            if (temp == 8) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }

    public static int testMagicSum(Scanner in) {
        final int SENTINEL = -1;
        int number;
        int sum = 0;

        System.out.print("Enter a positive integer (or -1 to end): ");
        number = in.nextInt();

        while (number != SENTINEL) {
            if (hasEight(number)) {
                sum += number;
            }
            System.out.print("Enter a positive integer (or -1 to end): ");
            number = in.nextInt();
        }

        in.close();
        return sum;
    }

    public static void realTestMagicSum() {
        Scanner in = new Scanner(System.in);
        System.out.println("The magic sum is: " + testMagicSum(in));
        in.close();
    }

    public static void print(int[] array) {
        if (array.length == 0) {
            System.out.print("[]");
        } else if (array.length == 1) {
            System.out.print("[" + array[0] + "]");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    System.out.print("[" + array[i]);
                } else if (i == array.length - 1) {
                    System.out.print(", " + array[i] + "]");
                } else {
                    System.out.print(", " + array[i]);
                }
            }
        }
    }

    public static void print(double[] array) {
        if (array.length == 0) {
            System.out.print("[]");
        } else if (array.length == 1) {
            System.out.print("[" + array[0] + "]");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    System.out.print("[" + array[i]);
                } else if (i == array.length - 1) {
                    System.out.print(", " + array[i] + "]");
                } else {
                    System.out.print(", " + array[i]);
                }
            }
        }
    }

    public static void print(float[] array) {
        if (array.length == 0) {
            System.out.print("[]");
        } else if (array.length == 1) {
            System.out.print("[" + array[0] + "]");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    System.out.print("[" + array[i]);
                } else if (i == array.length - 1) {
                    System.out.print(", " + array[i] + "]");
                } else {
                    System.out.print(", " + array[i]);
                }
            }
        }
    }

    public static String arrayToString(int[] array) {
        String resultStr = "";
        if (array.length == 0) {
            resultStr += "[]";
        } else if (array.length == 1) {
            resultStr += "[" + array[0] + "]";
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {

                    resultStr += "[" + array[i];
                } else if (i == array.length - 1) {

                    resultStr += ", " + array[i] + "]";
                } else {

                    resultStr += ", " + array[i];
                }
            }
        }
        return resultStr;
    }

    public static void testArrayToString() {
        int[] array = {1};
        System.out.print(arrayToString(array));
    }

    public static boolean contains(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return true;
            }
        }
        return false;
    }

    public static void testContains() {
        int[] array = {};
        int key = 3;
        System.out.print(contains(array, key));
    }

    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void testSearch() {
        int[] array = {1, 2, 3, 4, 5};
        int key = 3;
        System.out.print(search(array, key));
    }

    public static int[] copyOf(int[] array) {
        if (array == null) {
            return null;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void testCopyOf() {
        int[] original = {1, 2, 3, 4, 5};
        int[] copied = copyOf(original);

        System.out.println("Original array: ");
        print(original);
        System.out.println("\nCopied array: ");
        print(copied);
    }

    public static int[] copyOf(int[] array, int newLength) {
        if (array == null) {
            return null;
        }
        int[] copy = new int[newLength];
        for (int i = 0; i < Math.min(array.length, newLength); i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void testCopyOfNewLength() {
        int newLength = 4;
        int[] original = {1, 2, 3, 4, 5};

        int[] copied = copyOf(original, newLength);

        System.out.println("New Length = " + newLength);
        System.out.println("Original array: ");
        print(original);
        System.out.println("\nCopied array: ");
        print(copied);
    }

    public static boolean swap(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        } else {
            int temp;
            for (int i = 0; i < array1.length; i++) {
                temp = array1[i];
                array1[i] = array2[i];
                array2[i] = temp;
            }
//            print(array1);
            return true;
        }
    }

    public static void testSwap() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 4, 3, 2, 1};
        System.out.println(swap(array1, array2));
    }

    public static void reverse(int[] array) {
        int temp;
        if (array.length > 0) {
            for (int fIdx = 0, bIdx = array.length - 1; fIdx < bIdx; ++fIdx, --bIdx) {
                temp = array[fIdx];
                array[fIdx] = array[bIdx];
                array[bIdx] = temp;
            }
            print(array);
        } else {
            System.out.println("null");
        }
    }

    public static void testReverse() {
        int[] array = {1, 2, 3, 4, 5};
        reverse(array);
    }


    public static void main(String[] args) {
//        testExponent();
//        realTestMagicSum();
//        testArrayToString();
//        testContains();
//        testSearch();
//        testCopyOf();
//        testCopyOfNewLength();
//        testSwap();
        testReverse();

    }
}
