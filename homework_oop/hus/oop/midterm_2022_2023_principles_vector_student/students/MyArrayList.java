package hus.oop.midterm_2022_2023_principles_vector_student.students;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 2;
    private Object[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        data = new Object[DEFAULT_CAPACITY];
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
        if (index >= size) {
            return null;
        }
        return data[index];
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
        if (index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data[index] = payload;
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data = remove(data, index);

    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     *
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        if (size > data.length) {
            enlarge();
        }
        data[size] = payload;
        size++;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     *
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        if (index >= data.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size > data.length) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = payload;
        size++;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     *
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyArrayListIterator(data);
    }

    /**
     * Cấp phát gấp đôi chỗ cho list khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
//        int[] newStack = new int[elements.length * 2];
//        System.arraycopy(elements, 0, newStack, 0, elements.length);
//        elements = newStack;
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private Object[] remove(Object[] arr, int in) {

        if (arr == null || in < 0 || in >= arr.length) {
            return arr;
        }

        Object[] arr2 = new Object[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == in)
                continue;

            arr2[k++] = arr[i];
        }

        return arr2;
    }
}
