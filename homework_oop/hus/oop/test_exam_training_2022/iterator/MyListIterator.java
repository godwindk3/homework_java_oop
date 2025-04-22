package hus.oop.test_exam_training_2022.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyListIterator implements Iterator {
    private ArrayList<String> items;
    private int position;

    public MyListIterator(ArrayList<String> items) {
        this.items = items;
        this.position = 0;
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more items to iterate");
        }
        String item = items.get(position);
        position++;
        return item;
    }

    public boolean hasNext() {
        return position < items.size();
    }
}
