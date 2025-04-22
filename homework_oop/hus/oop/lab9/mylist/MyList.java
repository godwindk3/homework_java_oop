package hus.oop.lab9.mylist;

public interface MyList {
    void add(Object o, int index);

    void remove(int index);

    int size();

    Object get(int index);

    void add(Object o);
}
