package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.numbersystem;

import java.util.Random;
public class TestNumberSystem {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên nằm trong đoạn [2, 16] được sinh ngẫu nhiên.
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ra ngẫu nhiên.
                + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Random random = new Random();
        String digits = "0123456789ABCDEF";

        // Sinh ngẫu nhiên 3 số
        for (int i = 1; i <= 3; i++) {
            System.out.println("=== Test " + i + " ===");

            // Sinh ngẫu nhiên cơ số trong đoạn [2, 16]
            int radix = 2 + random.nextInt(15); // [2, 16]

            // Sinh ngẫu nhiên độ dài số trong đoạn [10, 30]
            int length = 10 + random.nextInt(21); // [10, 30]

            // Sinh ngẫu nhiên xâu ký tự biểu diễn số
            StringBuilder numberBuilder = new StringBuilder();
            for (int j = 0; j < length; j++) {
                int digitIndex = random.nextInt(radix); // [0, radix-1]
                numberBuilder.append(digits.charAt(digitIndex));
            }
            String numberPresentation = numberBuilder.toString();

            // Tạo MyNumber
            MyNumber myNumber = new MyNumber(numberPresentation, radix);

            // Tạo các converter
            BinaryConverter binaryConverter = new BinaryConverter(myNumber);
            OctalConverter octalConverter = new OctalConverter(myNumber);
            HexadecimalConverter hexConverter = new HexadecimalConverter(myNumber);

            // Đăng ký các converter với MyNumber
            myNumber.addConverter(binaryConverter);
            myNumber.addConverter(octalConverter);
            myNumber.addConverter(hexConverter);

            // Hiển thị số gốc
            System.out.println("Original number: " + numberPresentation);
            System.out.println("Radix: " + radix);

            // Thực hiện chuyển đổi ban đầu
            binaryConverter.convert();
            octalConverter.convert();
            hexConverter.convert();

            // Hiển thị kết quả chuyển đổi
            binaryConverter.display();
            octalConverter.display();
            hexConverter.display();

            System.out.println();
        }
    }
}
