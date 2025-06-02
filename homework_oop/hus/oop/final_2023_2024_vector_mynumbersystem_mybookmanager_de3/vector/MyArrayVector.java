package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.vector;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index không hợp lệ");
        return data[index];
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] result = new double[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index không hợp lệ");
        data[index] = value;
    }

    /**
     * Cộng các phần tử của vector với value.
     *
     * @param value
     * @return vector mới.
     */
    public MyArrayVector add(double value) {
        /* TODO */
        MyArrayVector result = new MyArrayVector();
        result.size = this.size;
        result.data = new double[data.length];
        for (int i = 0; i < size; i++) {
            result.data[i] = data[i] + value;
        }
        return result;
    }

    /**
     * Cộng các phần tử vector hiện tại với các phần tử vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector mới.
     */
    public MyArrayVector add(MyVector another) {
        /* TODO */
        if (this.size != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        MyArrayVector result = new MyArrayVector();
        result.size = this.size;
        result.data = new double[data.length];
        for (int i = 0; i < size; i++) {
            result.data[i] = this.data[i] + another.coordinate(i);
        }
        return result;
    }

    /**
     * Cộng các phần tử của vector với value.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    /**
     * Cộng các phần tử vector hiện tại với các phần tử vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector hiện tại.
     */
    public MyArrayVector addTo(MyVector another) {
        /* TODO */
        if (this.size != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        for (int i = 0; i < size; i++) {
            data[i] += another.coordinate(i);
        }
        return this;
    }

    /**
     * Trừ các phần tử của vector cho giá trị value.
     *
     * @return vector mới.
     */
    public MyArrayVector minus(double value) {
        /* TODO */
        MyArrayVector result = new MyArrayVector();
        result.size = this.size;
        result.data = new double[data.length];
        for (int i = 0; i < size; i++) {
            result.data[i] = data[i] - value;
        }
        return result;
    }

    /**
     * Trừ các phần tử của vector hiện tại cho các phần tử của vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector mới.
     */
    public MyArrayVector minus(MyVector another) {
        /* TODO */
        if (this.size != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        MyArrayVector result = new MyArrayVector();
        result.size = this.size;
        result.data = new double[data.length];
        for (int i = 0; i < size; i++) {
            result.data[i] = this.data[i] - another.coordinate(i);
        }
        return result;
    }

    /**
     * Trừ các phần tử của vector cho giá trị value.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector minusFrom(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] -= value;
        }
        return this;
    }

    /**
     * Trừ các phần tử của vector hiện tại cho các phần tử của vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector minusFrom(MyVector another) {
        /* TODO */
        if (this.size != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        for (int i = 0; i < size; i++) {
            data[i] -= another.coordinate(i);
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public double dot(MyVector another) {
        /* TODO */
        if (this.size != another.size()) throw new IllegalArgumentException("Hai vector không cùng số chiều");
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += data[i] * another.coordinate(i);
        }
        return result;
    }

    /**
     * Các phần tử của vector được lấy mũ power.
     *
     * @param power
     * @return vector hiện tại.
     */
    public MyArrayVector pow(double power) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    /**
     * Các phần tử của vector được nhân với value.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector scale(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] *= value;
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
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value) {
        /* TODO */
        if (size == data.length) enlarge();
        data[size++] = value;
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     *
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index không hợp lệ");
        if (size == data.length) enlarge();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     *
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index không hợp lệ");
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     *
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyArrayVector extract(int[] indices) {
        /* TODO */
        MyArrayVector result = new MyArrayVector();
        result.size = indices.length;
        result.data = new double[indices.length];
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= size) throw new IndexOutOfBoundsException("Index không hợp lệ");
            result.data[i] = data[indices[i]];
        }
        return result;
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     *
     * @return vector hiện tại.
     */
    private MyArrayVector enlarge() {
        /* TODO */
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        return this;
    }
}
