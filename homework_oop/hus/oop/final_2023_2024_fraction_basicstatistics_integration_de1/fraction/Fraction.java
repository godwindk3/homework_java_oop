package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.fraction;

public class Fraction implements FractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public Fraction() {
        /* TODO */
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     *
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        /* TODO */
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;

        // Đảm bảo mẫu số luôn dương
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     *
     * @param copyFraction
     */
    public Fraction(Fraction copyFraction) {
        /* TODO */
        this.numerator = copyFraction.numerator;
        this.denominator = copyFraction.denominator;
    }

    public int getNumerator() {
        /* TODO */
        return numerator;
    }

    public void setNumerator(int numerator) {
        /* TODO */
        this.numerator = numerator;
    }

    public int getDenominator() {
        /* TODO */
        return denominator;
    }

    public void setDenominator(int denominator) {
        /* TODO */
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;

        // Đảm bảo mẫu số luôn dương
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     *
     * @return
     */
    public byte byteValue() {
        /* TODO */
        return (byte) (numerator / denominator);

    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     *
     * @return
     */
    public int intValue() {
        /* TODO */
        return numerator / denominator;

    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     *
     * @return
     */
    public long longValue() {
        /* TODO */
        return (long) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     *
     * @return
     */
    public short shortValue() {
        /* TODO */
        return (short) (numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     *
     * @return
     */
    public double doubleValue() {
        /* TODO */
        return (double) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     *
     * @return
     */
    public float floatValue() {
        /* TODO */
        return (float) numerator / denominator;
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     *
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd() {
        /* TODO */
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    public void simplify() {
        /* TODO */
        int gcd = gcd();
        numerator /= gcd;
        denominator /= gcd;
    }

    @Override
    public int compareTo(Fraction another) {
        /* TODO */
        long left = (long) this.numerator * another.denominator;
        long right = (long) another.numerator * this.denominator;

        if (left < right) {
            return -1;
        } else if (left > right) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     *
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Fraction fraction = (Fraction) obj;

        // So sánh bằng cách so sánh tích chéo
        return (long) this.numerator * fraction.denominator ==
                (long) fraction.numerator * this.denominator;
    }

    @Override
    public int hashCode() {
        // Tạo hash code dựa trên giá trị thực của phân số
        long value = (long) numerator * 31 + denominator;
        return (int) (value ^ (value >>> 32));
    }
}
