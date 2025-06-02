package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.basicstatistics;

public class Node {
    public Number payload;
    public Node next;

    public Node(Number payload) {
        /* TODO */
        this.payload = payload;
        this.next = null;
    }

    public Node(Number payload, Node next) {
        /* TODO */
        this.payload = payload;
        this.next = next;
    }
}
