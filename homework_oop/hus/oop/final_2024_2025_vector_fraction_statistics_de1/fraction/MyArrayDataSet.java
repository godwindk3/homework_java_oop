package hus.oop.final_2024_2025_vector_fraction_statistics_de1.fraction;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        fractions = new MyFraction[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        this.fractions = fractions;
        this.length = fractions.length;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (!checkBoundaries(index, length)) {
            return false;
        }
        if (length == fractions.length) {
            allocateMore();
        }
        for (int i = length; i > index; i--) {
            fractions[i] = fractions[i - 1];
        }
        fractions[index] = fraction;
        length++;
        return true;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dữ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        if (length == fractions.length) {
            allocateMore();
        }
        fractions[length] = fraction;
        length++;
        return true;
    }

    @Override
    public MyArrayDataSet toSimplify() {
        MyFraction[] simplified = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            simplified[i] = new MyFraction(fractions[i]);
            simplified[i].simplify();
        }
        return new MyArrayDataSet(simplified);
    }

    @Override
    public MyArrayDataSet sortIncreasing() {
        MyFraction[] sorted = new MyFraction[length];
        System.arraycopy(fractions, 0, sorted, 0, length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sorted[i].compareTo(sorted[j]) > 0) {
                    MyFraction temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return new MyArrayDataSet(sorted);
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        MyFraction[] sorted = new MyFraction[length];
        System.arraycopy(fractions, 0, sorted, 0, length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sorted[i].compareTo(sorted[j]) < 0) {
                    MyFraction temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return new MyArrayDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(fractions[i].toString());
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dữ liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        MyFraction[] newFractions = new MyFraction[fractions.length * 2];
        System.arraycopy(fractions, 0, newFractions, 0, length);
        fractions = newFractions;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
    }
}