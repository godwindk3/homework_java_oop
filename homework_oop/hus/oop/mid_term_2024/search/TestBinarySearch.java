// File: hus/oop/search/TestBinarySearch.java
package hus.oop.mid_term_2024.search;

import java.util.Arrays;
import java.util.Random;

public class TestBinarySearch {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = rand.nextInt(11) + 20; // [20,30]
        double[] original = new double[size];
        for (int i = 0; i < size; i++) {
            original[i] = Math.round(rand.nextDouble() * 1000) / 10.0; // 0.0–100.0 với 1 chữ số thập phân
        }
        double target = original[rand.nextInt(size)];
        double missing = -1.0;

        BinarySearch bs = BinarySearch.getInstance();

        Sorter[] sorters = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort()
        };
        String[] names = {
                "Bubble Sort",
                "Insertion Sort",
                "Selection Sort"
        };

        for (int k = 0; k < sorters.length; k++) {
            bs.setSorter(sorters[k]);
            double[] data = Arrays.copyOf(original, original.length);
            System.out.println("Using " + names[k] + " Algorithm:");
            System.out.println("Before sorting: " + Arrays.toString(data));
            int idxFound = bs.search(data, target);
            System.out.println("After sorting:  " + Arrays.toString(data));
            System.out.println("Binary search giá trị " + target + ": " + idxFound);
            int idxMiss = bs.search(Arrays.copyOf(original, original.length), missing);
            System.out.println("Binary search giá trị " + missing + ": " + idxMiss);
            System.out.println();
        }
    }
}
