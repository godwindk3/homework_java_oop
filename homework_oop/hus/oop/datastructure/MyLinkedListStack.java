package hus.oop.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu linked list.
 */
public class MyLinkedListStack implements MyStack {
    private Node top;

    @Override
    public void push(int value) {
        /* TODO */
        // Create a new node with given data
        Node new_node = new Node(value);

        // Check if memory allocation for the new node
        // failed
        if (new_node == null) {
            System.out.println("\nStack Overflow");
            return;
        }

        // Link the new node to the current top node
        new_node.next = top;

        // Update the top to the new node
        top = new_node;
    }

    @Override
    public int pop() {

        // Check for stack underflow
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty Stack");
        } else {

            // Assign the current top to a temporary
            // variable
            Node temp = top;

            int test = top.data;

            // Update the top to the next node
            top = top.next;

            // Deallocate the memory of the old top node
            temp = null;
            return test;
        }
    }

    @Override
    public int peek() {
        // If stack is not empty, return the top element
        if (!isEmpty())
            return top.data;
        else {
            System.out.println("\nStack is empty");
            return Integer.MIN_VALUE;
        }
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return top == null;
    }
    @Override
    public String toString(){
        String retStr = "Contents:\n";

        Node current = top;
        while(current != null){
            retStr += current.data + " ";
            current = current.next;

        }
        return retStr;
    }
}
