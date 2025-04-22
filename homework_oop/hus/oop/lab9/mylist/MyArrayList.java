package hus.oop.lab9.mylist;


public class MyArrayList extends MyAbstractList {
    static final int INITIAL_SIZE = 16;
    Object[] elements;
    int size;

    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public void add(Object o) {
        if (size >= elements.length - 1) {
            enlarge();
        }
        elements[size++] = o;
    }

    @Override
    public void add(Object o, int idx) {
        if (size >= elements.length - 1) enlarge();
        try {
            checkBoundaries(idx, size);
            for (int i = size; i > idx; i--) {
                elements[i] = elements[i - 1];
            }
            elements[idx] = o;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't add " + o + " at index " + idx);
        }
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size - 1);
        return elements[index];
    }

    @Override
    public void remove(int idx) {
        try {
            checkBoundaries(idx, size - 1);
            for (int i = idx; i < size - 1; i++) elements[i] = elements[i + 1];
            size--;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot remove from " + idx);
        }
    }

    @Override
    public int size() {
        return size;
    }

    void enlarge() {
        Object[] tmp = new Object[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;
    }
}
