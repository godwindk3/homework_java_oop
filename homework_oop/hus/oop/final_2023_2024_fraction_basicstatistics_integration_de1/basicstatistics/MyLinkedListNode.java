package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.basicstatistics;

public class MyLinkedListNode {
    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        /* TODO */
        this.payload = payload;
        this.next = null;
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

    public MyLinkedListNode getNext() {
        /* TODO */
        return next;
    }

    public void setNext(MyLinkedListNode node) {
        /* TODO */
        this.next = node;
    }
}
