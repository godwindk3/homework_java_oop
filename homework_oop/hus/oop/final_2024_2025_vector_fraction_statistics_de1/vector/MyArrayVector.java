package hus.oop.final_2024_2025_vector_fraction_statistics_de1.vector;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
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
        double[] coords = new double[size];
        System.arraycopy(data, 0, coords, 0, size);
        return coords;
    }

    @Override
    public MyArrayVector insert(double value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        MyArrayVector extracted = new MyArrayVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
            }
            extracted.insert(data[idx]);
        }
        return extracted;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + value);
        }
        return result;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(this.coordinate(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector addTo(double value) {
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.coordinate(i);
        }
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - value);
        }
        return result;
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(this.coordinate(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        for (int i = 0; i < size; i++) {
            data[i] = value - data[i];
        }
        return this;
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < size; i++) {
            data[i] = another.coordinate(i) - data[i];
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += this.coordinate(i) * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyArrayVector pow(double power) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(Math.pow(data[i], power));
        }
        return result;
    }

    @Override
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
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}