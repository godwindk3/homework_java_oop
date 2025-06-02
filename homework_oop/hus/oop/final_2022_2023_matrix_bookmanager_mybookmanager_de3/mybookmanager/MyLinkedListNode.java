package hus.oop.final_2022_2023_matrix_bookmanager_mybookmanager_de3.mybookmanager;

public class MyLinkedListNode {
    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        /* TODO */
        this.payload = payload;
        next = null;
    }

    public MyLinkedListNode(Object payload, MyLinkedListNode next) {
        /* TODO */
        this.payload = payload;
        this.next = next;
    }

    public Object getPayload() {
        /* TODO */
        return payload;
    }

    public void setPayload(Object payload) {
        /* TODO */
        this.payload = payload;
    }

    public MyLinkedListNode getNext() {
        /* TODO */
        return next;
    }

    public void setNext(MyLinkedListNode node) {
        /* TODO */
        next = node;
    }
}
