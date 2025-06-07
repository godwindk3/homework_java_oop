package hus.oop.final_2024_2025_vector_fraction_statistics_de1.statistics;



public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double max = Double.NEGATIVE_INFINITY;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double min = Double.POSITIVE_INFINITY;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value < min) {
                min = value;
            }
        }
        return min;
    }



    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double sum = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            sum += iterator.next().doubleValue();
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double mean = mean();
        double sum = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            sum += (value - mean) * (value - mean);
        }
        return sum / data.size();
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double data) {
        return this.data.binarySearch(data);
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        MyList sorted = data.sortIncreasing();
        double[] ranks = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            MyIterator iterator = data.iterator(0);
            double value = 0;
            while (iterator.hasNext()) {
                value = iterator.next().doubleValue();
                if (value == sorted.iterator(0).next().doubleValue()) {
                    break;
                }
            }
            ranks[i] = i + 1;
        }
        return ranks;
    }
}