package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.basicstatistics;

public class MyLinkedList extends MyAbstractList {
    private Node head;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Number get(int index) {
        /* TODO */
        Node node = getNodeByIndex(index);
        return node.payload;
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node prev = getNodeByIndex(index - 1);
        prev.next = prev.next.next;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Number payload) {
        /* TODO */
        Node newNode = new Node(payload);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Number payload, int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        if (index == 0) {
            head = new Node(payload, head);
            return;
        }

        Node prev = getNodeByIndex(index - 1);
        Node newNode = new Node(payload, prev.next);
        prev.next = newNode;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            this.currentPosition = position;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size();
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Number next() {
            /* TODO */
            if (!hasNext()) {
                throw new RuntimeException("No more elements");
            }
            Number result = get(currentPosition);
            currentPosition++;
            return result;
        }

        @Override
        public void remove() {
            /* TODO */
            if (currentPosition <= 0) {
                throw new RuntimeException("No element to remove");
            }
            MyLinkedList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}
