package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.basicstatistics;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     *
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        if (data.size() == 0) {
            throw new RuntimeException("List is empty");
        }

        double max = ((Double) data.get(0)).doubleValue();
        for (int i = 1; i < data.size(); i++) {
            double value = ((Double) data.get(i)).doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     *
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        if (data.size() == 0) {
            throw new RuntimeException("List is empty");
        }

        double min = ((Double) data.get(0)).doubleValue();
        for (int i = 1; i < data.size(); i++) {
            double value = ((Double) data.get(i)).doubleValue();
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     *
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        if (data.size() == 0) {
            throw new RuntimeException("List is empty");
        }

        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += ((Double) data.get(i)).doubleValue();
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     *
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        if (data.size() == 0) {
            throw new RuntimeException("List is empty");
        }

        double mean = mean();
        double sumSquaredDiff = 0;

        for (int i = 0; i < data.size(); i++) {
            double value = ((Double) data.get(i)).doubleValue();
            double diff = value - mean;
            sumSquaredDiff += diff * diff;
        }

        return sumSquaredDiff / data.size();
    }
}
