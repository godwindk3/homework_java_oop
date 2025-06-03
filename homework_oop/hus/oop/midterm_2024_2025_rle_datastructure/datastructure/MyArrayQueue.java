package hus.oop.midterm_2024_2025_rle_datastructure.datastructure;

import java.util.NoSuchElementException;

public class MyArrayQueue implements MyQueue {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    public MyArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayQueue(int capacity) {
        elements = new int[capacity];
        headIndex = tailIndex = elements.length / 2;
        numberOfElements = 0;
    }

    @Override
    public void enqueue(int element) {
        /* TODO */
        if (isFull()) {
            grow();
        }
        elements[(tailIndex + 1) % elements.length] = element;
        tailIndex = (tailIndex + 1) % elements.length;
        numberOfElements++;
    }

    /*
     * Tăng kích thước queue gấp đôi.
     */
    private void grow() {
        /* TODO */
//        Object[] tmp = new Object[elements.length * 2];
//        System.arraycopy(elements, 0, tmp, 0, elements.length);
//        elements = tmp;
        int[] newQueue = new int[elements.length * 2];
        System.arraycopy(elements, 0, newQueue, 0, elements.length);
        elements = newQueue;
    }

    @Override
    public int dequeue() {
        /* TODO */

        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
//        int result = elements[(headIndex + 1) % elements.length];
//        headIndex = (headIndex + 1) % elements.length;
//        numberOfElements--;
//        return result;

        int temp = elements[headIndex];
//        elements[headIndex] = Integer.MIN_VALUE;
        elements = remove(elements, headIndex);
        if (elements.length == 0) {
            return temp;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return temp;
    }

    @Override
    public int peek() {
        /* TODO */
        return elements[headIndex];
    }

    @Override
    public boolean isEmpty() {
        /* TODO */

        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == elements.length;
    }

    public void printArrayQueue() {
        if (elements.length == 0) {
            System.out.println("[]");
        }

        for (int i = 0; i < elements.length; ++i) {
            if (elements.length == 1) {
                System.out.println("[" + elements[i] + "]");
            } else if (i == 0) {
                System.out.print("[" + elements[i]);
            } else if (i == elements.length - 1) {
                System.out.println(", " + elements[i] + "]");
            } else {
                System.out.print(", " + elements[i]);
            }

        }
    }

    public int[] remove(int[] arr, int in) {

        if (arr == null || in < 0 || in >= arr.length) {
            return arr;
        }

        int[] arr2 = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == in)
                continue;

            arr2[k++] = arr[i];
        }

        return arr2;
    }
}
