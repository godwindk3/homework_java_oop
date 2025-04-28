package hus.oop.midterm_2023_good_code.students;

import java.util.Arrays;

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
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        return data[index];
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        data[index] = payload;
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Di chuyển các phần tử từ vị trí index + 1 về trước một vị trí
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // Đặt phần tử cuối cùng về null (để tránh dữ liệu thừa)
        data[size - 1] = null;

        // Cập nhật size
        size--;

    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
// Kiểm tra nếu mảng đầy
        if (size == data.length) {
            enlarge(); // Gọi phương thức enlarge để mở rộng mảng
        }

        // Thêm phần tử vào cuối mảng
        data[size] = payload;

        // Tăng kích thước của danh sách
        size++;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Nếu mảng đầy, mở rộng dung lượng mảng
        if (size == data.length) {
            enlarge(); // Gọi phương thức enlarge để mở rộng mảng
        }

        // Di chuyển các phần tử từ vị trí index về sau một vị trí
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        // Thêm phần tử vào vị trí index
        data[index] = payload;

        // Tăng kích thước danh sách
        size++;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
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
        // Tăng kích thước mảng lên gấp đôi
        int newCapacity = data.length * 2;

        // Sao chép dữ liệu từ mảng cũ sang mảng mới với dung lượng lớn hơn
        data = Arrays.copyOf(data, newCapacity);
    }
}
