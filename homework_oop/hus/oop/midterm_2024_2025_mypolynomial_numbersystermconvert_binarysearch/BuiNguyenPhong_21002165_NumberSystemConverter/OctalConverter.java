package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_NumberSystemConverter;

import java.math.BigInteger;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber originalNumber) {
        super(originalNumber);
    }

    // chuyển từ decimal string sang octal
    @Override
    public String decimalTo(String number) {
        BigInteger big = new BigInteger(number);
        return big.toString(8);
    }

    // trả về MyNumber mới với phần biểu diễn đã chuyển và radix = 8
    @Override
    public MyNumber getNumber() {
        convert();
        return new MyNumber(convertedNumber, 8);
    }
}
