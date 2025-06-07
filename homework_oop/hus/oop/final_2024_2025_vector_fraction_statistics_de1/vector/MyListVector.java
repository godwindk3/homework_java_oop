package hus.oop.final_2024_2025_vector_fraction_statistics_de1.vector;

import java.util.List;
import java.util.ArrayList;

public class MyListVector extends MyAbstractVector {
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
    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector extract(int[] indices) {
        MyListVector extracted = new MyListVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= data.size()) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + idx);
            }
            extracted.insert(data.get(idx));
        }
        return extracted;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data.set(index, value);
    }

    @Override
    public MyListVector add(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d + value);
        }
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.insert(this.coordinate(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d - value);
        }
        return result;
    }

    @Override
    public MyListVector minus(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.insert(this.coordinate(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, value - data.get(i));
        }
        return this;
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, another.coordinate(i) - data.get(i));
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        double result = 0;
        for (int i = 0; i < size(); i++) {
            result += this.coordinate(i) * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyListVector pow(double power) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(Math.pow(d, power));
        }
        return result;
    }

    @Override
    public MyListVector scale(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0;
        for (double d : data) {
            sum += d * d;
        }
        return Math.sqrt(sum);
    }
}
