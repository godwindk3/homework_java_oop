package hus.oop.test_exam_training_2024.BuiNguyenPhong_21002165_NumberSystemConverter;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(MyNumber originalNumber) {
        super(originalNumber);
    }

    // chuyển từ decimal string sang binary
    @Override
    public String decimalTo(String number) {
        BigInteger big = new BigInteger(number);
        return big.toString(2);
    }

    // trả về MyNumber mới với phần biểu diễn đã chuyển và radix = 2
    @Override
    public MyNumber getNumber() {
        convert();
        return new MyNumber(convertedNumber, 2);
    }
}
