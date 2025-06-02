package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.numbersystem;

import java.math.BigInteger;
public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;  // Số gốc
    protected String convertedNumber;   // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberConverter(MyNumber originalNumber) {
        /* TODO */
        this.originalNumber = originalNumber;
        this.convertedNumber = "";
    }

    /*
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /*
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     *
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        /* TODO */
        String number = originalNumber.getNumberPresentation();
        int radix = originalNumber.getRadix();

        BigInteger result = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(radix);

        // Thuật toán Horner: result = result * radix + digit
        for (int i = 0; i < number.length(); i++) {
            char digitChar = number.charAt(i);
            int digit;

            // Chuyển ký tự thành giá trị số
            if (digitChar >= '0' && digitChar <= '9') {
                digit = digitChar - '0';
            } else if (digitChar >= 'A' && digitChar <= 'F') {
                digit = digitChar - 'A' + 10;
            } else if (digitChar >= 'a' && digitChar <= 'f') {
                digit = digitChar - 'a' + 10;
            } else {
                throw new IllegalArgumentException("Invalid digit: " + digitChar);
            }

            result = result.multiply(base).add(BigInteger.valueOf(digit));
        }

        return result.toString();
    }

    /**
     * Thực hiện chuyển đổi số từ biểu diễn số và hệ cơ số ban đầu trong originalNumber
     * sang số có hệ cơ số nào đó. Kết quả số được chuyển đổi được lưu trong biến 
     * thành viên convertedNumber.
     */
    public void convert() {
        /* TODO */
        String decimal = toDecimal();
        convertedNumber = decimalTo(decimal);
    }
}
