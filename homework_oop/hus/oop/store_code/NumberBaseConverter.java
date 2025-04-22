package hus.oop.store_code;

//public class NumberBaseConverter {
//    // Hàm chính để chuyển đổi giữa các cơ số
//    public static String convertBase(String number, int sourceBase, int targetBase) {
//        // Kiểm tra cơ số hợp lệ
//        if (sourceBase < 2 || sourceBase > 36 || targetBase < 2 || targetBase > 36) {
//            throw new IllegalArgumentException("Cơ số phải từ 2 đến 36");
//        }
//
//        // Chuyển số từ cơ số nguồn sang cơ số 10
//        long decimalValue = toDecimal(number, sourceBase);
//
//        // Chuyển từ cơ số 10 sang cơ số đích
//        return fromDecimal(decimalValue, targetBase);
//    }
//
//    // Chuyển số từ cơ số bất kỳ sang cơ số 10
//    private static long toDecimal(String number, int sourceBase) {
//        number = number.toUpperCase();
//        long result = 0;
//
//        for (char digit : number.toCharArray()) {
//            int value;
//            if (Character.isDigit(digit)) {
//                value = digit - '0';
//            } else if (Character.isLetter(digit)) {
//                value = digit - 'A' + 10;
//            } else {
//                throw new IllegalArgumentException("Ký tự không hợp lệ: " + digit);
//            }
//
//            if (value >= sourceBase) {
//                throw new IllegalArgumentException("Ký tự " + digit + " không hợp lệ trong cơ số " + sourceBase);
//            }
//
//            result = result * sourceBase + value;
//        }
//
//        return result;
//    }
//
//    // Chuyển số từ cơ số 10 sang cơ số bất kỳ
//    private static String fromDecimal(long decimalValue, int targetBase) {
//        if (decimalValue == 0) {
//            return "0";
//        }
//
//        StringBuilder result = new StringBuilder();
//        while (decimalValue > 0) {
//            int remainder = (int) (decimalValue % targetBase);
//            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
//            result.insert(0, digit);
//            decimalValue /= targetBase;
//        }
//
//        return result.toString();
//    }
//
//
//    public static void main(String[] args) {
//        // Ví dụ: Chuyển từ cơ số 16 sang cơ số 2
//        System.out.println(convertBase("1A", 16, 2)); // Kết quả: 11010
//        // Chuyển từ cơ số 10 sang cơ số 8
//        System.out.println(convertBase("42", 10, 8)); // Kết quả: 52
//        // Chuyển từ cơ số 8 sang cơ số 16
//        System.out.println(convertBase("77", 8, 16)); // Kết quả: 3F
//    }
//}

public class NumberBaseConverter {
    // Chuyển từ cơ số 10 sang cơ số đích
    public static String decimalTo(String number, int targetBase) {
        // Kiểm tra cơ số đích hợp lệ
        if (targetBase < 2 || targetBase > 36) {
            throw new IllegalArgumentException("Cơ số đích phải từ 2 đến 36");
        }

        // Chuyển chuỗi số cơ số 10 thành giá trị long
        long decimalValue;
        try {
            decimalValue = Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Số cơ số 10 không hợp lệ: " + number);
        }

        // Chuyển từ cơ số 10 sang cơ số đích
        if (decimalValue == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (decimalValue > 0) {
            int remainder = (int) (decimalValue % targetBase);
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            result.insert(0, digit);
            decimalValue /= targetBase;
        }

        return result.toString();
    }

    // Chuyển từ cơ số nguồn sang cơ số 10
    public static String toDecimal(String number, int sourceBase) {
        // Kiểm tra cơ số nguồn hợp lệ
        if (sourceBase < 2 || sourceBase > 36) {
            throw new IllegalArgumentException("Cơ số nguồn phải từ 2 đến 36");
        }

        number = number.toUpperCase();
        long result = 0;

        // Xử lý từng ký tự trong số
        for (char digit : number.toCharArray()) {
            int value;
            if (Character.isDigit(digit)) {
                value = digit - '0';
            } else if (Character.isLetter(digit)) {
                value = digit - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Ký tự không hợp lệ: " + digit);
            }

            if (value >= sourceBase) {
                throw new IllegalArgumentException("Ký tự " + digit + " không hợp lệ trong cơ số " + sourceBase);
            }

            result = result * sourceBase + value;
        }

        return String.valueOf(result);
    }

    // Chuyển từ cơ số nguồn sang cơ số đích
    public static String toRadix(String number, int sourceBase, int targetBase) {
        // Kiểm tra cơ số hợp lệ
        if (sourceBase < 2 || sourceBase > 36 || targetBase < 2 || targetBase > 36) {
            throw new IllegalArgumentException("Cơ số phải từ 2 đến 36");
        }

        // Chuyển từ cơ số nguồn sang cơ số 10
        String decimalValue = toDecimal(number, sourceBase);

        // Chuyển từ cơ số 10 sang cơ số đích
        return decimalTo(decimalValue, targetBase);
    }

    // Main để thử nghiệm
    public static void main(String[] args) {
        // Chuyển từ cơ số 16 sang cơ số 10
        System.out.println(toDecimal("1A", 16)); // Kết quả: 26

        // Chuyển từ cơ số 10 sang cơ số 8
        System.out.println(decimalTo("42", 8)); // Kết quả: 52

        // Chuyển từ cơ số 8 sang cơ số 2
        System.out.println(toRadix("77", 8, 2)); // Kết quả: 111111

        // Chuyển từ cơ số 16 sang cơ số 2
        System.out.println(toRadix("1A", 16, 2)); // Kết quả: 11010
    }
}
