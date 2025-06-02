package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.mynumbersystem;

import java.math.BigInteger;

public abstract class AbstractNumberSystemConverter implements NumberSystemConverter {
    protected String convertedNumber;         // Số được chuyển đổi theo cơ số nào đó từ số gốc
    protected ANumber number;

    public AbstractNumberSystemConverter(ANumber aNumber) {
        /* TODO */
        this.number = aNumber;
        // ngay khi khởi tạo, hãy cập nhật convertedNumber dựa trên aNumber hiện tại
        update(aNumber);
    }

    /**
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     *
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     * <p>
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     * <p>
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /**
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     *
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     * <p>
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        /* TODO */
        String repr = number.getNumberPresentation().toUpperCase(); // ví dụ "1A3F"
        int base = number.getRadix();                              // ví dụ 16
        // Dùng Horner: result = 0; for mỗi ký tự c: result = result*base + digit(c)
        BigInteger result = BigInteger.ZERO;
        BigInteger b = BigInteger.valueOf(base);

        for (int i = 0; i < repr.length(); i++) {
            char c = repr.charAt(i);
            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else {
                // A-F → 10-15
                digit = 10 + (c - 'A');
            }
            result = result.multiply(b).add(BigInteger.valueOf(digit));
        }
        return result.toString();
    }
}
