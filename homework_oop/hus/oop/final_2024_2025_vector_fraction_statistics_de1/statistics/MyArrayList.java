package hus.oop.final_2024_2025_vector_fraction_statistics_de1.statistics;


public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double data) {
        if (size == this.data.length) {
            allocateMore();
        }
        this.data[size] = data;
        size++;
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == this.data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        MyArrayList sorted = new MyArrayList();
        double[] temp = new double[size];
        System.arraycopy(data, 0, temp, 0, size);
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (temp[i] > temp[j]) {
                    double swap = temp[i];
                    temp[i] = temp[j];
                    temp[j] = swap;
                }
            }
        }
        for (double d : temp) {
            sorted.add(d);
        }
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        MyArrayList sorted = sortIncreasing();
        int left = 0;
        int right = sorted.size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted.data[mid] == data) {
                return mid;
            } else if (sorted.data[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            if (position < 0 || position > size) {
                throw new IndexOutOfBoundsException("Invalid starting position: " + position);
            }
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("Cannot remove before first element");
            }
            MyArrayList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}
