package hus.oop.final_2024_2025_vector_fraction_statistics_de1.statistics;


public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        top = null;
    }

    @Override
    public int size() {
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            newNode.next = top;
            if (top != null) {
                top.previous = newNode;
            }
            top = newNode;
        } else {
            MyNode current = getNodeByIndex(index - 1);
            newNode.next = current.next;
            newNode.previous = current;
            if (current.next != null) {
                current.next.previous = newNode;
            }
            current.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            top = top.next;
            if (top != null) {
                top.previous = null;
            }
        } else {
            MyNode current = getNodeByIndex(index);
            current.previous.next = current.next;
            if (current.next != null) {
                current.next.previous = current.previous;
            }
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        MyLinkedList sorted = new MyLinkedList();
        MyNode current = top;
        while (current != null) {
            sorted.add(current.data);
            current = current.next;
        }
        for (int i = 0; i < sorted.size() - 1; i++) {
            MyNode nodeI = sorted.getNodeByIndex(i);
            for (int j = i + 1; j < sorted.size(); j++) {
                MyNode nodeJ = sorted.getNodeByIndex(j);
                if (nodeI.data > nodeJ.data) {
                    double temp = nodeI.data;
                    nodeI.data = nodeJ.data;
                    nodeJ.data = temp;
                }
            }
        }
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        MyLinkedList sorted = sortIncreasing();
        int left = 0;
        int right = sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            MyNode midNode = sorted.getNodeByIndex(mid);
            if (midNode.data == data) {
                return mid;
            } else if (midNode.data < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        MyNode current = top;
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
        private MyNode currentNode;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            if (position < 0 || position > size()) {
                throw new IndexOutOfBoundsException("Invalid starting position: " + position);
            }
            currentPosition = position;
            currentNode = getNodeByIndex(position);
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            double value = currentNode.data;
            currentNode = currentNode.next;
            currentPosition++;
            return value;
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("Cannot remove before first element");
            }
            MyLinkedList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}