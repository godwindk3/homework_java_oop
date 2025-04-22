package hus.oop.test_exam_training_2022.iterator;

import java.util.NoSuchElementException;

public class MyArrayIterator implements Iterator {
    private String[] items;
    private int position;

    public MyArrayIterator(String[] items) {
        this.items = items;
        this.position = 0;
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more items to iterate");
        }
        String item = items[position];
        position++;
        return item;
    }

    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }
}