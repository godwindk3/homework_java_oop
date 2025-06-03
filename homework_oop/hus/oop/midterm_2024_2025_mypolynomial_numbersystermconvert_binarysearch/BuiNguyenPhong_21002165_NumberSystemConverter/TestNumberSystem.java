package hus.oop.midterm_2024_2025_mypolynomial_numbersystermconvert_binarysearch.BuiNguyenPhong_21002165_NumberSystemConverter;

public class TestNumberSystem {
    public TestNumberSystem() {
    }

    public static void main(String[] args) {
        // Tạo MyNumber ở hệ 10
        MyNumber decimalNumber = new MyNumber("255", 10);

        // Chuyển sang hệ nhị phân
        NumberConverter binaryConverter = new BinaryConverter(decimalNumber);
        MyNumber binaryNumber = binaryConverter.getNumber();
        System.out.println("Decimal to Binary: " + binaryNumber.getNumberPresentation()); // 11111111

        // Chuyển sang hệ bát phân
        NumberConverter octalConverter = new OctalConverter(decimalNumber);
        MyNumber octalNumber = octalConverter.getNumber();
        System.out.println("Decimal to Octal: " + octalNumber.getNumberPresentation()); // 377

        // Chuyển sang hệ thập lục phân
        NumberConverter hexConverter = new HexadecimalConverter(decimalNumber);
        MyNumber hexNumber = hexConverter.getNumber();
        System.out.println("Decimal to Hexadecimal: " + hexNumber.getNumberPresentation()); // FF

        // Test chuyển từ hệ khác về hệ khác: từ hex FF (16) -> binary (2)
        MyNumber hexInput = new MyNumber("FF", 16);
        NumberConverter binaryFromHex = new BinaryConverter(hexInput);
        MyNumber binaryResult = binaryFromHex.getNumber();
        System.out.println("Hexadecimal FF to Binary: " + binaryResult.getNumberPresentation()); // 11111111
    }
}
