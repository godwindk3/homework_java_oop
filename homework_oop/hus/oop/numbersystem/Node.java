package hus.oop.numbersystem;

public class Node {
    public int data;
    public Node next;

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
