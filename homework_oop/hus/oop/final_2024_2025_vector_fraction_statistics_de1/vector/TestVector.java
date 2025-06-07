package hus.oop.final_2024_2025_vector_fraction_statistics_de1.vector;

import java.util.Random;

public class TestVector {
    private MyVector vector;

    public TestVector(MyVector vector) {
        this.vector = vector;
    }

    public static void main(String[] args) {
        TestVector testArray = new TestVector(new MyArrayVector());
        testArray.testArrayVector();

        TestVector testList = new TestVector(new MyListVector());
        testList.testListVector();

        /* TODO
           - Thực hiện các hàm test.
           - Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
             (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
             <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */
    }

    public void testArrayVector() {
        Random rand = new Random();
        int n = 5 + rand.nextInt(10); // Sinh ngẫu nhiên từ 5 đến 14
        MyArrayVector vector = new MyArrayVector();
        for (int i = 0; i < n; i++) {
            vector.insert(rand.nextDouble() * 100);
        }

        System.out.println("Original Vector: " + vector.toString());

        // Thêm phần tử
        vector.insert(50.0);
        System.out.println("After insert 50.0: " + vector.toString());

        // Xóa phần tử
        vector.remove(0);
        System.out.println("After remove first element: " + vector.toString());

        // Sửa giá trị
        vector.set(100.0, 1);
        System.out.println("After set 100.0 at index 1: " + vector.toString());

        // Cộng với giá trị
        MyArrayVector added = vector.add(10.0);
        System.out.println("After add 10.0: " + added.toString());

        // Cộng với vector khác
        MyArrayVector another = new MyArrayVector();
        for (int i = 0; i < vector.size(); i++) {
            another.insert(rand.nextDouble() * 10);
        }
        MyArrayVector addedVector = vector.add(another);
        System.out.println("After add another vector: " + addedVector.toString());

        // Nhân với vô hướng
        vector.scale(2.0);
        System.out.println("After scale by 2.0: " + vector.toString());

        // Tích vô hướng
        double dotProduct = vector.dot(another);
        System.out.println("Dot product with another vector: " + dotProduct);

        // Chuẩn vector
        double norm = vector.norm();
        System.out.println("Norm of vector: " + norm);
    }

    public void testListVector() {
        Random rand = new Random();
        int n = 5 + rand.nextInt(10); // Sinh ngẫu nhiên từ 5 đến 14
        MyListVector vector = new MyListVector();
        for (int i = 0; i < n; i++) {
            vector.insert(rand.nextDouble() * 100);
        }

        System.out.println("Original Vector: " + vector.toString());

        // Thêm phần tử
        vector.insert(50.0);
        System.out.println("After insert 50.0: " + vector.toString());

        // Xóa phần tử
        vector.remove(0);
        System.out.println("After remove first element: " + vector.toString());

        // Sửa giá trị
        vector.set(100.0, 1);
        System.out.println("After set 100.0 at index 1: " + vector.toString());

        // Cộng với giá trị
        MyListVector added = vector.add(10.0);
        System.out.println("After add 10.0: " + added.toString());

        // Cộng với vector khác
        MyListVector another = new MyListVector();
        for (int i = 0; i < vector.size(); i++) {
            another.insert(rand.nextDouble() * 10);
        }
        MyListVector addedVector = vector.add(another);
        System.out.println("After add another vector: " + addedVector.toString());

        // Nhân với vô hướng
        vector.scale(2.0);
        System.out.println("After scale by 2.0: " + vector.toString());

        // Tích vô hướng
        double dotProduct = vector.dot(another);
        System.out.println("Dot product with another vector: " + dotProduct);

        // Chuẩn vector
        double norm = vector.norm();
        System.out.println("Norm of vector: " + norm);
    }
}
