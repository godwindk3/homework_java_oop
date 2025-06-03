package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.bai1;

import java.math.BigInteger;

public class MyMath {
    private static final double PI = Math.PI;
    private static final int MAX_TERMS = 20;

    public MyMath() {
    }

    public static double exp(double x) {
        if (Math.abs(x) > 709) {
            throw new IllegalArgumentException("Giá trị x quá lớn cho exp(x)");
        }

        double result = 0.0;
        double term = 1.0;

        for (int n = 0; n < MAX_TERMS; n++) {
            result += term;

            term *= x / (n + 1);
        }

        return result;
    }

    public static double cos(double x) {

        x = x % (2 * PI);
        if (x > PI) x -= 2 * PI;
        if (x < -PI) x += 2 * PI;

        double result = 0.0;
        double term = 1.0;
        double xSquared = x * x;

        for (int n = 0; n < MAX_TERMS; n++) {
            result += term;

            term *= -xSquared / ((2 * n + 1) * (2 * n + 2));
        }

        return result;
    }

    public static String toDecimal(String number, int inRadix) {
        // Kiểm tra cơ số hợp lệ
        if (inRadix < 2 || inRadix > 16) {
            throw new IllegalArgumentException("Cơ số nguồn phải từ 2 đến 16");
        }

        number = number.toUpperCase();
        BigInteger result = BigInteger.ZERO;

        // Phương pháp Horner: result = result * inRadix + giá trị chữ số
        for (char digit : number.toCharArray()) {
            int value;
            if (digit >= '0' && digit <= '9') {
                value = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                value = digit - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Ký tự không hợp lệ: " + digit);
            }

            if (value >= inRadix) {
                throw new IllegalArgumentException("Ký tự " + digit + " không hợp lệ trong cơ số " + inRadix);
            }

            result = result.multiply(BigInteger.valueOf(inRadix)).add(BigInteger.valueOf(value));
        }

        return result.toString();
    }

    // Chuyển từ cơ số 10 sang cơ số outRadix dùng thuật toán Euclid
    public static String decimalTo(String number, int outRadix) {
        // Kiểm tra cơ số hợp lệ
        if (outRadix < 2 || outRadix > 16) {
            throw new IllegalArgumentException("Cơ số đích phải từ 2 đến 16");
        }

        // Chuyển chuỗi số cơ số 10 thành BigInteger
        BigInteger decimalValue;
        try {
            decimalValue = new BigInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Số cơ số 10 không hợp lệ: " + number);
        }

        // Xử lý trường hợp số 0
        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }

        // Thuật toán Euclid: chia lấy nguyên và dư
        StringBuilder result = new StringBuilder();
        while (!decimalValue.equals(BigInteger.ZERO)) {
            BigInteger[] divRem = decimalValue.divideAndRemainder(BigInteger.valueOf(outRadix));
            int remainder = divRem[1].intValue();
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            result.insert(0, digit);
            decimalValue = divRem[0];
        }

        return result.toString();
    }

    // Chuyển từ cơ số inRadix sang cơ số outRadix
    public static String toRadix(String number, int inRadix, int outRadix) {
        // Kiểm tra cơ số hợp lệ
        if (inRadix < 2 || inRadix > 16 || outRadix < 2 || outRadix > 16) {
            throw new IllegalArgumentException("Cơ số phải từ 2 đến 16");
        }

        // Chuyển từ cơ số inRadix sang cơ số 10
        String decimalValue = toDecimal(number, inRadix);

        // Chuyển từ cơ số 10 sang cơ số outRadix
        return decimalTo(decimalValue, outRadix);
    }


    public static void main(String[] args) {

        //
        System.out.println("cos(pi/3) ≈ " + cos(PI / 3)); // ~0.5
        System.out.println("Math.cos(pi/3) = " + Math.cos(PI / 3));

        //
        System.out.println("exp(1) ≈ " + exp(1)); //  ~2.71828
        System.out.println("Math.exp(1) = " + Math.exp(1));


        System.out.println("Base 16 to base 10: toDecimal(\"1A\", 16): " + toDecimal("1A", 16)); //  26

        System.out.println("Base 10 to base 8: decimalTo(\"42\", 8): " + decimalTo("42", 8)); //  52

        System.out.println("Base 8 to base 2: toRadix(\"77\", 8, 2): " + toRadix("77", 8, 2)); //  111111

        System.out.println("Base 16 to base 2: toRadix(\"1A\", 16, 2): " + toRadix("1A", 16, 2)); //  11010

        System.out.println("e^2.2 * cos(3.3) = " + (exp(2.2) * cos(3.3)));
        System.out.println("Math.exp(2.2) * Math.cos(3.3) = " + (Math.exp(2.2) * Math.cos(3.3)));
        System.out.println("Base 13 to base 8: " + toRadix("123456789123456789", 13, 8));

    }


}
