package hus.oop.datastructure;

public class MyLinkedListQueue implements MyQueue {
    private Node head;
    private Node tail;



    public MyLinkedListQueue() {
        this.head = this.tail = null;
    }

    @Override
    public void enqueue(int element) {
        /* TODO */
        Node temp = new Node(element);

        if (isEmpty()) {
            this.head = this.tail = temp;
            return;
        }

        this.tail.next = temp;
        this.tail = temp;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        Node temp = this.head;

        int test = this.head.data;

        this.head = this.head.next;

        if (head == null) tail = null;
        temp = null;

        return test;
    }

    @Override
    public int peek() {
        if (this.head != null)
            return this.head.data;

        // Return Exception
        return Integer.MIN_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    void printQueue() {
        Node temp = this.head;

        System.out.print("Element of Queue : ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
