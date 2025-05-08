package hus.oop.numbersystem;

public class MyLinkedList extends MyAbstractList {
    private Node start;
    private Node end;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        this.start = null;
        this.size = 0;

    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     *
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        /* TODO */
        return getNodeByIndex(index).data;

    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     *
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        if (checkBoundaries(index, size)) {
            Node newNode = new Node(data);
            Node current = start;
            if (index == 0) {
                newNode.setNext(start.getNext());
                start = newNode;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                newNode.setNext(current.getNext().getNext());
                current.setNext(newNode);
            }
        }
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */

    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     *
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.setNext(start);
            start = newNode;
        } else {
            Node prev = getNodeByIndex(index - 1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (checkBoundaries(index, size)) {
            if (index == 0) {
                start = start.getNext();
            } else {
                Node prev = getNodeByIndex(index - 1);
                prev.setNext(prev.getNext().getNext());
            }
            size--;
        }
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     *
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (checkBoundaries(index, size)) {
            Node current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;

        }
        return null;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     *
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */

        Node current = start;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }
}
