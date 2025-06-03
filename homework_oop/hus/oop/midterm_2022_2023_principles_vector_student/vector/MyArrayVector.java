//package hus.oop.midterm_2023.vector;
//
//public class MyArrayVector extends AbstractMyVector {
//    private static final int DEFAULT_CAPACITY = 1;
//    private double[] data;
//    private int size;
//
//    /**
//     * Khởi tạo mặc định cho vector.
//     */
//    public MyArrayVector() {
//        /* TODO */
//    }
//
//    @Override
//    public int size() {
//        /* TODO */
//        return 0;
//    }
//
//    @Override
//    public double coordinate(int index) {
//        /* TODO */
//        return 0;
//    }
//
//    @Override
//    public double[] coordinates() {
//        /* TODO */
//        return null;
//    }
//
//    @Override
//    public void set(double value, int index) {
//        /* TODO */
//    }
//
//    /**
//     * Cộng các giá trị tọa độ với value.
//     * @param value
//     * @return vector hiện tại.
//     */
//    public MyArrayVector add(double value) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Cộng vector khác vào vector hiện tại.
//     * Nếu hai vector không cùng số chiều thì không cộng được.
//     * In ra thông báo lỗi hoặc ném exception.
//     * @param another
//     * @return vector hiện tại.
//     */
//    public MyArrayVector add(MyArrayVector another) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Trừ các giá trị tọa độ của vector cho value.
//     * @return vector hiện tại.
//     */
//    public MyArrayVector minus(double value) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Trừ vector hiện tại với vector khác.
//     * Nếu hai vector không cùng số chiều thì không trừ được.
//     * In ra thông báo lỗi hoặc ném exception.
//     * @return
//     */
//    public MyArrayVector minus() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Trừ vector hiện tại với vector khác.
//     * Nếu hai vector không cùng số chiều thì không trừ được.
//     * In ra thông báo lỗi hoặc ném exception.
//     * @return vector hiện tại.
//     */
//    public MyArrayVector minus(MyArrayVector another) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Tích vô hướng của hai vector.
//     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
//     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
//     * @return vector hiện tại.
//     */
//    public MyArrayVector dot() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Các giá trị của vector được lấy mũ power.
//     * @param power
//     * @return vector hiện tại.
//     */
//    public MyArrayVector pow(double power) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Các giá trị tọa độ của vector được nhân với value.
//     * @return vector hiện tại.
//     */
//    public MyArrayVector scale(double value) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Lấy chuẩn của vector.
//     * @return chuẩn của vector.
//     */
//    @Override
//    public double norm() {
//        /* TODO */
//        return 0;
//    }
//
//    /**
//     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
//     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
//     * @param value
//     * @return vector hiện tại.
//     */
//    public MyArrayVector insert(double value) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Thêm một giá trị vào tọa độ vector ở vị trí index.
//     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
//     * @param value
//     * @param index
//     * @return vector hiện tại.
//     */
//    public MyArrayVector insert(double value, int index) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Xóa giá trị ở tọa độ thứ index.
//     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
//     * @param index
//     * @return vector hiện tại.
//     */
//    public MyArrayVector remove(int index) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
//     * được lấy theo các chỉ số của mảng đầu vào.
//     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
//     * có tọa độ là [2 1].
//     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
//     * hoặc ném exception.
//     * @param indices
//     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
//     */
//    public MyArrayVector extract(int[] indices) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
//     * @return vector hiện tại.
//     */
//    private MyArrayVector enlarge() {
//        /* TODO */
//        return null;
//    }
//}
package hus.oop.midterm_2022_2023_principles_vector_student.vector;

import java.util.Arrays;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 1;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data[index] = value;
    }

    /**
     * Cộng các giá trị tọa độ với value.
     * @param value giá trị cần cộng
     * @return vector hiện tại
     */
    public MyArrayVector add(double value) {
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * @param another vector khác để cộng
     * @return vector hiện tại
     */
    public MyArrayVector add(MyArrayVector another) {
        if (this.size != another.size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.data[i];
        }
        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     * @param value giá trị cần trừ
     * @return vector hiện tại
     */
    public MyArrayVector minus(double value) {
        for (int i = 0; i < size; i++) {
            data[i] -= value;
        }
        return this;
    }

    /**
     * Trừ vector hiện tại với vector khác (không hợp lệ, sửa thành phương thức dưới).
     * @return không sử dụng
     */
    public MyArrayVector minus() {
        throw new UnsupportedOperationException("Method not implemented. Use minus(MyArrayVector) instead.");
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * @param another vector khác để trừ
     * @return vector hiện tại
     */
    public MyArrayVector minus(MyArrayVector another) {
        if (this.size != another.size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < size; i++) {
            data[i] -= another.data[i];
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector (sửa thành phương thức trả về double).
     * @return không sử dụng
     */
    public MyArrayVector dot() {
        throw new UnsupportedOperationException("Method not implemented. Use dot(MyArrayVector) instead.");
    }

    /**
     * Tính tích vô hướng của hai vector.
     * @param another vector khác để tính tích vô hướng
     * @return giá trị tích vô hướng
     */
    public double dot(MyArrayVector another) {
        if (this.size != another.size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += data[i] * another.data[i];
        }
        return result;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     * @param power số mũ
     * @return vector hiện tại
     */
    public MyArrayVector pow(double power) {
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     * @param value giá trị nhân
     * @return vector hiện tại
     */
    public MyArrayVector scale(double value) {
        for (int i = 0; i < size; i++) {
            data[i] *= value;
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * @param value giá trị cần thêm
     * @return vector hiện tại
     */
    public MyArrayVector insert(double value) {
        if (size == data.length) {
            enlarge();
        }
        data[size] = value;
        size++;
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * @param value giá trị cần thêm
     * @param index vị trí thêm
     * @return vector hiện tại
     */
    public MyArrayVector insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == data.length) {
            enlarge();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * @param index vị trí cần xóa
     * @return vector hiện tại
     */
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu.
     * @param indices các chỉ số cần trích xuất
     * @return vector mới
     */
    public MyArrayVector extract(int[] indices) {
        MyArrayVector result = new MyArrayVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
            }
            result.insert(data[idx]);
        }
        return result;
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     * @return vector hiện tại
     */
    private MyArrayVector enlarge() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
        return this;
    }
}