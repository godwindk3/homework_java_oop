package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.mynumbersystem;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class NumberSystemTestDrive {
    public static void main(String[] args) throws FileNotFoundException {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên khác 10 nằm trong đoạn [2, 16] được sinh ngẫu nhiên (nếu sinh ra 10 thì sinh lại).
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
        PrintStream out = new PrintStream("BuiNguyenPhong_21002165_NumberSystemConverter.txt");
        System.setOut(out);

        Random rand = new Random();
        // Tạo 3 số ngẫu nhiên
        for (int k = 0; k < 3; k++) {
            // 1) Sinh cơ số (radix) trong [2..16], nếu ra 10 thì sinh lại
            int radix;
            do {
                radix = rand.nextInt(15) + 2; // random từ 2 đến 16
            } while (radix == 10);

            // 2) Sinh độ dài chuỗi trong [10..30]
            int length = rand.nextInt(21) + 10;

            // 3) Sinh từng chữ số: index trong [0..radix-1], mapping qua "0123456789ABCDEF"
            final String DIGITS = "0123456789ABCDEF";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int idx = rand.nextInt(radix);
                sb.append(DIGITS.charAt(idx));
            }
            String originalStr = sb.toString();

            // In thông tin gốc
            System.out.println("Original number: " + originalStr);
            System.out.println("radix " + radix);

            // Tạo ANumber cho lần thử này
            ANumber aNum = new ANumber(originalStr, radix);

            // Tạo lần lượt 3 converter (Binary, Octal, Hex) dựa trên cùng ANumber
            BinaryConverter binConv = new BinaryConverter(aNum);
            OctalConverter octConv = new OctalConverter(aNum);
            HexadecimalConverter hexConv = new HexadecimalConverter(aNum);

            // Hiển thị kết quả
            binConv.display();
            octConv.display();
            hexConv.display();

            System.out.println(); // xuống dòng tách lần thử tiếp theo
        }

        out.close();
    }
}
