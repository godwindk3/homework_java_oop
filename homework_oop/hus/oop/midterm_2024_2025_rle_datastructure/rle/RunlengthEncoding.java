package hus.oop.midterm_2024_2025_rle_datastructure.rle;

import java.util.Collections;

public class RunlengthEncoding {
    public static void main(String[] args) {
        /*
        TODO:

        - Viết các hàm test mã hóa và giải mã theo mã hóa run-length và in ra theo mẫu:
        Ví dụ:
        Decoded Text: xxxxx
        Encoded Text: xxxxx

        và

        Encoded Text: xxxxx
        Decoded Text: xxxxx


         */
        testEncoding();
        testDecoding();
    }

    /*
     * Hàm mã hóa chuỗi ký tự text theo mã hóa run-length.
     */

    // 2 hàm encoding và decoding được em tham khảo tại:  https://www.baeldung.com/java-rle-compression
    public static String encoding(String text) {
        /* TODO */
        StringBuilder result = new StringBuilder();
        int count = 1;
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i + 1 < chars.length && c == chars[i + 1]) {
                count++;
            } else {
                result.append(count).append(c);
                count = 1;
            }
        }
        return result.toString();
    }

    /*
     * Hàm giải mã chuỗi ký tự text theo mã hóa run-length.
     */
    public static String decoding(String text) {
        /* TODO */
        StringBuilder result = new StringBuilder();
        char[] chars = text.toCharArray();

        int count = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                count = 10 * count + Character.getNumericValue(c);
            } else {
                result.append(String.join("", Collections.nCopies(count, String.valueOf(c))));
                count = 0;
            }
        }
        return result.toString();
    }

    /*
     * Hàm test mã hóa theo mã hóa run-length.
     */
    public static void testEncoding() {
        /* TODO */
        String str = "aaaaabcccaa";
        System.out.println("Decoded text: " + str);
        System.out.println("Encoded text: " + encoding(str));
    }

    /*
     * Hàm test giải mã theo mã hóa run-length.
     */
    public static void testDecoding() {
        /* TODO */
        String str = "3e4f2e";
        System.out.println("Encoded text: " + str);
        System.out.println("Decoded text: " + decoding(str));

    }
}
