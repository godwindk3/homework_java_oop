package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index không hợp lệ");
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] result = new double[size()];
        for (int i = 0; i < size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index không hợp lệ");
        data.set(index, value);
    }

    /**
     * Cộng các phần tử của vector với value.
     *
     * @param value
     * @return vector mới.
     */
    public MyListVector add(double value) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.data.add(data.get(i) + value);
        }
        return result;
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector mới.
     */
    public MyListVector add(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.data.add(data.get(i) + another.coordinate(i));
        }
        return result;
    }

    /**
     * Cộng các phần tử của vector với value.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector addTo(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    /**
     * Trừ các phần tử của vector cho value.
     *
     * @return vector mới.
     */
    public MyListVector minus(double value) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.data.add(data.get(i) - value);
        }
        return result;
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector mới.
     */
    public MyListVector minus(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.data.add(data.get(i) - another.coordinate(i));
        }
        return result;
    }

    /**
     * Trừ các phần tử của vector cho value.
     *
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(double value) {
        /* TODO */
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) - another.coordinate(i));
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     *
     * @return tích vô hướng.
     */
    public double dot(MyVector another) {
        /* TODO */
        if (this.size() != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        double result = 0;
        for (int i = 0; i < size(); i++) {
            result += data.get(i) * another.coordinate(i);
        }
        return result;
    }

    /**
     * Các phần tử vector được lấy mũ power.
     *
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
        for (int i = 0; i < size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    /**
     * Các phần tử vector được nhân với value.
     *
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    /**
     * Lấy chuẩn của vector.
     *
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += data.get(i) * data.get(i);
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào vector ở vị trí cuối cùng.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
        data.add(value);
        return this;
    }

    /**
     * Thêm một giá trị vào vector ở vị trí index.
     *
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Index không hợp lệ");
        data.add(index, value);
        return this;
    }

    /**
     * Xóa phần tử ở vị trí index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     *
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        /* TODO */
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index không hợp lệ");
        data.remove(index);
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các phần tử
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     *
     * @param indices
     * @return vector mới có kiểu MyListVector có các phần tử được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= size()) throw new IndexOutOfBoundsException("Index không hợp lệ");
            result.data.add(data.get(indices[i]));
        }
        return result;
    }
}
