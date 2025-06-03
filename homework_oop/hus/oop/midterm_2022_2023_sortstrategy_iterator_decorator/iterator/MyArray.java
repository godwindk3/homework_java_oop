package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.iterator;

public class MyArray implements MyIterable {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems;
    private String[] menuItems;

    public MyArray() {
        numberOfItems = 0;
        menuItems = new String[MAX_ITEMS];
    }

    public void addItem(String name) {
        if (numberOfItems >= MAX_ITEMS) {
            throw new IllegalStateException("Array is full, cannot add more items");
        }
        menuItems[numberOfItems] = name;
        numberOfItems++;
    }

    public String[] getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator() {
        return new MyArrayIterator(menuItems);
    }

    public String toString() {
        return "My Array Structure";
    }
}
