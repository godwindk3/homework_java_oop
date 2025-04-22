package hus.oop.lab9.mylist;

public class MyLinkedList extends MyAbstractList {
    int size;
    MyLinkedListNode head;


    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(Object o, int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            head = new MyLinkedListNode(o, head);
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode(o, current.getNext()));
        }
        size++;
    }

    @Override
    public void remove(int index) {

    }

    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void add(Object o) {
        add(o, size);
    }

    @Override
    public Object get(int index) {
        return null;
    }


}
