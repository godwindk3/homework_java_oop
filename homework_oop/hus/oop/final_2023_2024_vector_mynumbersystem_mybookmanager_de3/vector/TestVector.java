package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.vector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestVector {
    public static void main(String[] args) {
        /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
           - Tạo ra các vector có kích thước n, với các phần tử được sinh ngẫu nhiên. Trong đó có 2 vector kiểu MyArrayList
             và 2 vector có kiểu MyListVector.
           - Viết các hàm để test các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
             phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
             đổi vector hoặc tính toán, in kết quả ra terminal.

         II. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
              <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */
        Random rand = new Random();
        int n = rand.nextInt(10) + 1; // Sinh ngẫu nhiên n từ 1 đến 10
        StringBuilder output = new StringBuilder();

        // Tạo 2 vector kiểu MyArrayVector
        MyArrayVector arrayVec1 = new MyArrayVector();
        MyArrayVector arrayVec2 = new MyArrayVector();
        for (int i = 0; i < n; i++) {
            arrayVec1.insert(rand.nextDouble() * 10);
            arrayVec2.insert(rand.nextDouble() * 10);
        }

        // Tạo 2 vector kiểu MyListVector
        MyListVector listVec1 = new MyListVector();
        MyListVector listVec2 = new MyListVector();
        for (int i = 0; i < n; i++) {
            listVec1.insert(rand.nextDouble() * 10);
            listVec2.insert(rand.nextDouble() * 10);
        }

        // Test các chức năng và ghi kết quả
        output.append("n = ").append(n).append("\n");
        output.append("arrayVec1 = ").append(arrayVec1).append("\n");
        output.append("arrayVec2 = ").append(arrayVec2).append("\n");
        output.append("listVec1 = ").append(listVec1).append("\n");
        output.append("listVec2 = ").append(listVec2).append("\n");

        // Thêm phần tử
        arrayVec1.insert(5.0);
        listVec1.insert(5.0);
        output.append("Sau khi thêm 5.0 vào arrayVec1: ").append(arrayVec1).append("\n");
        output.append("Sau khi thêm 5.0 vào listVec1: ").append(listVec1).append("\n");

        // Xóa phần tử
        arrayVec1.remove(0);
        listVec1.remove(0);
        output.append("Sau khi xóa phần tử đầu tiên của arrayVec1: ").append(arrayVec1).append("\n");
        output.append("Sau khi xóa phần tử đầu tiên của listVec1: ").append(listVec1).append("\n");

        // Sửa giá trị
        arrayVec1.set(10.0, 0);
        listVec1.set(10.0, 0);
        output.append("Sau khi sửa phần tử đầu tiên của arrayVec1 thành 10.0: ").append(arrayVec1).append("\n");
        output.append("Sau khi sửa phần tử đầu tiên của listVec1 thành 10.0: ").append(listVec1).append("\n");

        // Cộng vector với số
        MyVector arrayVecAdd = arrayVec1.add(2.0);
        MyVector listVecAdd = listVec1.add(2.0);
        output.append("arrayVec1 + 2.0 = ").append(arrayVecAdd).append("\n");
        output.append("listVec1 + 2.0 = ").append(listVecAdd).append("\n");

        // Cộng hai vector
        MyVector arraySum = arrayVec1.add(arrayVec2);
        MyVector listSum = listVec1.add(listVec2);
        output.append("arrayVec1 + arrayVec2 = ").append(arraySum).append("\n");
        output.append("listVec1 + listVec2 = ").append(listSum).append("\n");

        // Tích vô hướng
        double dotArray = arrayVec1.dot(arrayVec2);
        double dotList = listVec1.dot(listVec2);
        output.append("Tích vô hướng arrayVec1 và arrayVec2 = ").append(dotArray).append("\n");
        output.append("Tích vô hướng listVec1 và listVec2 = ").append(dotList).append("\n");

        // Chuẩn vector
        double normArray = arrayVec1.norm();
        double normList = listVec1.norm();
        output.append("Chuẩn của arrayVec1 = ").append(normArray).append("\n");
        output.append("Chuẩn của listVec1 = ").append(normList).append("\n");

        // In kết quả ra terminal
        System.out.print(output.toString());

        // Lưu vào file
        try (FileWriter writer = new FileWriter("NguyenVanA_123456_Vector.txt")) {
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
