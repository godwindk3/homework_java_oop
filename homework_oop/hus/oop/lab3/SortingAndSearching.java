package hus.oop.lab3;

import java.util.Scanner;

public class SortingAndSearching {
    public static int[] createArray(Scanner in) {
        final int NUM_ITEMS;
        int[] items;


        System.out.print("Enter the number of items: ");
        NUM_ITEMS = in.nextInt();

        items = new int[NUM_ITEMS];

        System.out.print("Enter the value of all items (separated by space): ");
        if (items.length > 0) {
            for (int i = 0; i < items.length; ++i) {
                items[i] = in.nextInt();
            }
        }

        return items;
    }

    public static void printArray(int[] items) {

        for (int i = 0; i < items.length; ++i) {
            if (i == 0) {
                System.out.print("[" + items[i]);
            } else if (i == items.length - 1) {
                System.out.println(", " + items[i] + "]");
            } else {
                System.out.print(", " + items[i]);
            }

        }
    }

    public static boolean linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static int linearSearchIndex(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return 0;
    }

    public static void testLinearSearch() {
        Scanner in = new Scanner(System.in);
        int[] array = createArray(in);

        System.out.print("Enter the key: ");
        int key = in.nextInt();
        in.close();

        System.out.println(linearSearch(array, key));
        System.out.println("The index of key is: " + linearSearchIndex(array, key));

    }


    public static boolean binarySearch(int[] array, int key, int fromIdx, int toIdx) {
        if (fromIdx > toIdx) {
            return false;
        }
        int middleIdx = (fromIdx + toIdx) / 2;

        if (key == array[middleIdx]) {
            return true;
        } else if (key < array[middleIdx]) {
            return binarySearch(array, key, fromIdx, middleIdx - 1);
        } else {
            return binarySearch(array, key, middleIdx + 1, toIdx);
        }
    }


    public static boolean binarySearch(int[] array, int key) {
        int fromIdx = 0;
        int toIdx = array.length - 1;
        int middleIdx;
        while (fromIdx <= toIdx) {
            middleIdx = (fromIdx + toIdx) / 2;
            if (array[middleIdx] == key) {
                return true;
            } else if (key < array[middleIdx]) {
                toIdx = middleIdx - 1;
            } else {
                fromIdx = middleIdx + 1;
            }
        }
        return false;
    }

    public static void testBinarySearch() {
        Scanner in = new Scanner(System.in);
        int[] array = createArray(in);

        System.out.print("Enter the key: ");
        int key = in.nextInt();

        in.close();

//        System.out.println(binarySearch(array, key, 0, array.length - 1));
        System.out.print(binarySearch(array, key));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length - 1;
        boolean swapped;
        int temp;
        do {
            swapped = false;
            for (int i = 0; i < n; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            n -= 1;
        } while (swapped);
    }

    public static void testBubbleSort() {
        Scanner in = new Scanner(System.in);
        int[] array = createArray(in);
        System.out.print("Sorted: ");
        bubbleSort(array);
        printArray(array);
        in.close();
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        int minIdx;
        for (int i = 0; i < n - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
    }

    public static void testSelectionSort() {
        Scanner in = new Scanner(System.in);
        int[] array = createArray(in);
        System.out.print("Sorted: ");
        in.close();
        selectionSort(array);
        printArray(array);
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void testInsertionSort() {
        Scanner in = new Scanner(System.in);
        int[] array = createArray(in);
        System.out.print("Sorted: ");
        in.close();
        insertionSort(array);
        printArray(array);
    }


    public static void main(String[] args) {
//        testLinearSearch();
//        testBinarySearch();
//        testBubbleSort();
//        testSelectionSort();
        testInsertionSort();

    }


}
