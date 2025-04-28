package hus.oop.midterm_2023.vector;

import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
    }

    @Override
    public int size() {
        /* TODO */
        return 0;
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        return 0;
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        return null;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
    }

    /**
     * Cộng các giá trị tọa độ với value.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector add(double value) {
        /* TODO */
        return null;
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector add(MyListVector another) {
        /* TODO */
        return null;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     * @return vector hiện tại.
     */
    public MyListVector minus(double value) {
        /* TODO */
        return null;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return
     */
    public MyListVector minus() {
        /* TODO */
        return null;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector minus(MyListVector another) {
        /* TODO */
        return null;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector dot() {
        /* TODO */
        return null;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
        return null;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
        return null;
    }

    /**
     * Lấy chuẩn của vector.
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
        return 0;
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
        return null;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
        return null;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector remove(int index) {
        /* TODO */
        return null;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        /* TODO */
        return null;
    }
}
