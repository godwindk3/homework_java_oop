package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_NumberSystemConverter;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberConverter {
    public HexadecimalConverter(MyNumber originalNumber) {
        super(originalNumber);
    }

    // chuyển từ decimal string sang hexadecimal (in hoa)
    @Override
    public String decimalTo(String number) {
        BigInteger big = new BigInteger(number);
        return big.toString(16).toUpperCase();
    }

    // trả về MyNumber mới với phần biểu diễn đã chuyển và radix = 16
    @Override
    public MyNumber getNumber() {
        convert();
        return new MyNumber(convertedNumber, 16);
    }
}
