package hus.oop.final_2022_2023_mymath_studentmanager_studentmanager2_de2.studentmanager2;

public class MyLinkedListNode {
    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        /* TODO */
        this.payload = payload;
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
        next = node;
    }
}
