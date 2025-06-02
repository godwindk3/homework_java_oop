package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.numbersystem;

import java.math.BigInteger;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger number = new BigInteger(decimal);
        BigInteger base = BigInteger.valueOf(8);

        if (number.equals(BigInteger.ZERO)) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Thuật toán Euclid: chia liên tục cho 8 và lấy phần dư
        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = number.remainder(base);
            result.insert(0, remainder.toString());
            number = number.divide(base);
        }

        return result.toString();
    }

    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal 
     * số được chuyển đổi theo định dạng a1a2...an(8).
     */
    @Override
    public void update() {
        /* TODO */
        convert();
        display();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println("Octal: " + convertedNumber + "(8)");
    }
}
