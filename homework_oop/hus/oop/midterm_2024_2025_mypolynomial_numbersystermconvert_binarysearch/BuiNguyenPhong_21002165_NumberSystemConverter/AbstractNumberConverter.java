package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_NumberSystemConverter;

import java.math.BigInteger;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;
    protected String convertedNumber;

    public AbstractNumberConverter(MyNumber originalNumber) {
        this.originalNumber = originalNumber;
    }

    // Chuyển đổi chung: bất kể hệ gốc là gì, trước tiên đưa về decimal, rồi từ decimal sang hệ đích
    @Override
    public void convert() {
        String original = originalNumber.getNumberPresentation();
        // 1) về decimal
        String decimal = toDecimal(original);
        // 2) từ decimal sang hệ đích (được triển khai ở subclass)
        convertedNumber = decimalTo(decimal);
    }

    // Chuyển một chuỗi trong hệ originalNumber.radix về hệ 10 dưới dạng String

    public String toDecimal(String number) {
        BigInteger big = new BigInteger(number, originalNumber.getRadix());
        return big.toString();
    }

    // Để subclass override; default không xóa mà để trống
    public String decimalTo(String number) {
        return "";
    }
}
