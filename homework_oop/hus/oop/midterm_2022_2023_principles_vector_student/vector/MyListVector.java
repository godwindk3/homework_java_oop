//package hus.oop.midterm_2023.vector;
//
//import java.util.List;
//
//public class MyListVector extends AbstractMyVector {
//    private List<Double> data;
//
//    /**
//     * Khởi tạo mặc định cho vector.
//     */
//    public MyListVector() {
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
//    public MyListVector add(double value) {
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
//    public MyListVector add(MyListVector another) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Trừ các giá trị tọa độ của vector cho value.
//     * @return vector hiện tại.
//     */
//    public MyListVector minus(double value) {
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
//    public MyListVector minus() {
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
//    public MyListVector minus(MyListVector another) {
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
//    public MyListVector dot() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Các giá trị của vector được lấy mũ power.
//     * @param power
//     * @return vector hiện tại.
//     */
//    public MyListVector pow(double power) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Các giá trị tọa độ của vector được nhân với value.
//     * @return vector hiện tại.
//     */
//    public MyListVector scale(double value) {
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
//     * @param value
//     * @return vector hiện tại.
//     */
//    public MyListVector insert(double value) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Thêm một giá trị vào tọa độ vector ở vị trí index.
//     * @param value
//     * @param index
//     * @return vector hiện tại.
//     */
//    public MyListVector insert(double value, int index) {
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
//    public MyListVector extract(int[] indices) {
//        /* TODO */
//        return null;
//    }
//}
package hus.oop.midterm_2022_2023_principles_vector_student.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] coords = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            coords[i] = data.get(i);
        }
        return coords;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data.set(index, value);
    }

    /**
     * Cộng các giá trị tọa độ với value.
     * @param value giá trị cần cộng
     * @return vector hiện tại
     */
    public MyListVector add(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * @param another vector khác để cộng
     * @return vector hiện tại
     */
    public MyListVector add(MyListVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.data.get(i));
        }
        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     * @param value giá trị cần trừ
     * @return vector hiện tại
     */
    public MyListVector minus(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại với vector khác (không hợp lệ).
     * @return không sử dụng
     */
    public MyListVector minus() {
        throw new UnsupportedOperationException("Method not implemented. Use minus(MyListVector) instead.");
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * @param another vector khác để trừ
     * @return vector hiện tại
     */
    public MyListVector minus(MyListVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - another.data.get(i));
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector (sửa thành phương thức trả về double).
     * @return không sử dụng
     */
    public MyListVector dot() {
        throw new UnsupportedOperationException("Method not implemented. Use dot(MyListVector) instead.");
    }

    /**
     * Tính tích vô hướng của hai vector.
     * @param another vector khác để tính
     * @return giá trị tích vô hướng
     */
    public double dot(MyListVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        double result = 0;
        for (int i = 0; i < data.size(); i++) {
            result += data.get(i) * another.data.get(i);
        }
        return result;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     * @param power số mũ
     * @return vector hiện tại
     */
    public MyListVector pow(double power) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     * @param value giá trị nhân
     * @return vector hiện tại
     */
    public MyListVector scale(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0;
        for (double val : data) {
            sum += val * val;
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * @param value giá trị cần thêm
     * @return vector hiện tại
     */
    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * @param value giá trị cần thêm
     * @param index vị trí thêm
     * @return vector hiện tại
     */
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data.add(index, value);
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * @param index vị trí cần xóa
     * @return vector hiện tại (sửa kiểu trả về)
     */
    public MyListVector remove(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data.remove(index);
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu.
     * @param indices các chỉ số cần trích xuất
     * @return vector mới
     */
    public MyListVector extract(int[] indices) {
        MyListVector result = new MyListVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= data.size()) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
            }
            result.insert(data.get(idx));
        }
        return result;
    }
}
