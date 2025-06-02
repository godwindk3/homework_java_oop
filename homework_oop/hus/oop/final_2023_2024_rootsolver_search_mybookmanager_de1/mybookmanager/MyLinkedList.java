package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.mybookmanager;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator(int start) {
            /* TODO */
            this.currentPosition = start;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        @Override
        public Object next() {
            /* TODO */
            Node node = getNodeByIndex(currentPosition);
            currentPosition++;
            return node.data;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
        Node node = getNodeByIndex(index);
        node.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        /* TODO */
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for insert.");
        }
        if (index == 0) {
            insertAtStart(value);
        } else if (index == size) {
            insertAtEnd(value);
        } else {
            Node prev = getNodeByIndex(index - 1);
            Node newNode = new Node(value);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for remove.");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for getNodeByIndex.");
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }
}
