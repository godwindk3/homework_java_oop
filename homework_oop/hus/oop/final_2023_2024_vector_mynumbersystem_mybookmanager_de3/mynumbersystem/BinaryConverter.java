package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.mynumbersystem;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberSystemConverter {
    public BinaryConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger dec = new BigInteger(decimal);
        if (dec.equals(BigInteger.ZERO)) {
            return "0";
        }
        BigInteger two = BigInteger.valueOf(2);
        StringBuilder sb = new StringBuilder();
        while (dec.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] qr = dec.divideAndRemainder(two);
            int remainder = qr[1].intValue();
            sb.append(remainder);
            dec = qr[0];
        }
        return sb.reverse().toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update(ANumber number) {
        /* TODO */
        this.number = number;
        String decimal = toDecimal();          // ANumber → decimal string
        this.convertedNumber = decimalTo(decimal);
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println("Binary: " + convertedNumber + "(2)");
    }
}
