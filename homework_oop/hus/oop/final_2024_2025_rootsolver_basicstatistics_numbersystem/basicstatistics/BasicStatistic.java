package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.basicstatistics;

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

        double maxValue = data.get(0).doubleValue();
        for (int i = 1; i < data.size(); i++) {
            double value = data.get(i).doubleValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
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

        double minValue = data.get(0).doubleValue();
        for (int i = 1; i < data.size(); i++) {
            double value = data.get(i).doubleValue();
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
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
            sum += data.get(i).doubleValue();
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

        double meanValue = mean();
        double sumSquaredDifferences = 0;

        for (int i = 0; i < data.size(); i++) {
            double value = data.get(i).doubleValue();
            double difference = value - meanValue;
            sumSquaredDifferences += difference * difference;
        }

        return sumSquaredDifferences / data.size();
    }
}
