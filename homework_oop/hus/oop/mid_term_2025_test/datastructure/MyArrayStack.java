package hus.oop.mid_term_2025_test.datastructure;

import java.util.NoSuchElementException;

/**
 * Stack sử dụng cấu trúc dữ liệu mảng.
 */
public class MyArrayStack implements MyStack {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int numberOfElements;

    public MyArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
        numberOfElements = 0;
    }

    public MyArrayStack(int initialCapacity) {
        /* TODO */
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    @Override
    public void push(int value) {
        /* TODO */
        if (numberOfElements == elements.length - 1) {
            grow();
        }
        int[] newStack = new int[elements.length + 1];
        newStack[0] = value;
        System.arraycopy(elements, 0, newStack, 1, elements.length);
        numberOfElements++;
        elements = newStack;

    }

    /*
     * Tăng kích thước stack lên gấp đôi.
     */
    private void grow() {
        int[] newStack = new int[elements.length * 2];
        System.arraycopy(elements, 0, newStack, 0, elements.length);
        elements = newStack;
    }

    @Override
    public int pop() {
        /* TODO */
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty!");
        }
        int popElement = elements[0];
        elements = remove(elements, 0);
        numberOfElements--;
        return popElement;
    }

    @Override
    public int peek() {
        /* TODO */
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty!");
        }

        return elements[0];
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return numberOfElements == 0;
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

    public void printArrayStack() {
        if (numberOfElements == 0) {
            System.out.println("[]");
        }

        for (int i = 0; i < numberOfElements; ++i) {
            if (numberOfElements == 1) {
                System.out.println("[" + elements[i] + "]");
            } else if (i == 0) {
                System.out.print("[" + elements[i]);
            } else if (i == numberOfElements - 1) {
                System.out.println(", " + elements[i] + "]");
            } else {
                System.out.print(", " + elements[i]);
            }

        }
    }
}
