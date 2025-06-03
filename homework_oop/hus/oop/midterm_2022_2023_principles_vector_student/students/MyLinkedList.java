package hus.oop.midterm_2022_2023_principles_vector_student.students;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
        size = 0;
    }

    /**
     * Lấy kích thước của list.
     *
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     *
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        Object element = getNodeByIndex(index).getPayload();
        return element;
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     *
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
//        MyLinkedListNode current = getNodeByIndex(index);
//        if (current != null) {
//            current.setPayload(payload);
//        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        MyLinkedListNode current = getNodeByIndex(index - 1);

        if (index == 0) {
            head = new MyLinkedListNode(payload, head.getNext());
//            if head null:
//            head = new MyLinkedListNode(payload, null);
//            size++;
        } else {
            current.setNext(new MyLinkedListNode(payload, current.getNext().getNext()));
        }
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        MyLinkedListNode current = getNodeByIndex(index - 1);
        if (index == size - 1) {
            current.setNext(null);
        } else {
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     *
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        insert(payload, size);
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     *
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        if (index == 0) {
            head = new MyLinkedListNode(payload, head);
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode(payload, current.getNext()));
        }
        size++;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     *
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(head);
    }

    /**
     * Lấy node ở vị trí index.
     *
     * @param index
     * @return
     */

    private MyLinkedListNode getNodeByIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
}
