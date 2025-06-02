package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.fraction;

public class DataSet {
    private static int DEFAULT_CAPACITY = 8;
    private Fraction[] data;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public DataSet() {
        data = new Fraction[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số theo data.
     *
     * @param data
     */
    public DataSet(Fraction[] data) {
        this.data = new Fraction[data.length];
        this.length = data.length;
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    /**
     * In ra mảng các phân số fractions theo định dạng [a1, a2, ... , an].
     *
     * @param fractions
     */
    public static void printFractions(Fraction[] fractions) {
        /* TODO */
        if (fractions.length == 0) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < fractions.length; i++) {
            sb.append(fractions[i].toString());
            if (i < fractions.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     *
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    public boolean insert(Fraction fraction, int index) {
        /* TODO */
        if (!checkBoundaries(index, length)) {
            return false;
        }

        if (length >= data.length) {
            enlarge();
        }

        // Dịch chuyển các phần tử về phía sau
        for (int i = length; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = fraction;
        length++;
        return true;
    }

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     *
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    public DataSet toSimplify() {
        /* TODO */
        Fraction[] simplifiedFractions = new Fraction[length];

        for (int i = 0; i < length; i++) {
            simplifiedFractions[i] = new Fraction(data[i]); // Copy constructor
            simplifiedFractions[i].simplify();
        }

        return new DataSet(simplifiedFractions);
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     *
     * @param fraction
     * @return
     */
    public void append(Fraction fraction) {
        /* TODO */
        if (length >= data.length) {
            enlarge();
        }

        data[length] = fraction;
        length++;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     *
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    public Fraction[] sortIncreasing() {
        /* TODO */
        Fraction[] sortedArray = new Fraction[length];
        System.arraycopy(data, 0, sortedArray, 0, length);

        // Bubble sort với custom comparator
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                int comparison = sortedArray[j].compareTo(sortedArray[j + 1]);

                // Nếu giá trị bằng nhau, so sánh theo mẫu số
                if (comparison == 0) {
                    comparison = Integer.compare(sortedArray[j].getDenominator(),
                            sortedArray[j + 1].getDenominator());
                }

                if (comparison > 0) {
                    // Swap
                    Fraction temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     *
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    public Fraction[] sortDecreasing() {
        /* TODO */
        Fraction[] sortedArray = new Fraction[length];
        System.arraycopy(data, 0, sortedArray, 0, length);

        // Bubble sort với custom comparator (ngược lại)
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                int comparison = sortedArray[j].compareTo(sortedArray[j + 1]);

                // Nếu giá trị bằng nhau, so sánh theo mẫu số (giảm dần)
                if (comparison == 0) {
                    comparison = Integer.compare(sortedArray[j + 1].getDenominator(),
                            sortedArray[j].getDenominator());
                }

                if (comparison < 0) {
                    // Swap
                    Fraction temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void enlarge() {
        /* TODO */
        Fraction[] newData = new Fraction[data.length * 2];
        System.arraycopy(data, 0, newData, 0, length);
        data = newData;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     *
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        /* TODO */
        return index >= 0 && index <= upperBound;
    }

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     *
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        if (length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < length; i++) {
            sb.append(data[i].toString());
            if (i < length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public int getLength() {
        return length;
    }

    public Fraction[] getData() {
        Fraction[] result = new Fraction[length];
        System.arraycopy(data, 0, result, 0, length);
        return result;
    }

}
