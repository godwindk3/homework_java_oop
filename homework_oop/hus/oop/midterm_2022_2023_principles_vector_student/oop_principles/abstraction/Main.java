package hus.oop.midterm_2022_2023_principles_vector_student.oop_principles.abstraction;

public class Main {
//    Định nghĩa: Chỉ lộ ra những gì cần thiết, ẩn đi chi tiết thực thi. Thường dùng abstract class hoặc interface để
//    định nghĩa hành vi chung, còn lớp con chịu trách nhiệm hiện thực.

    public static void main(String[] args) {
//        Shape chỉ mô tả “có thể tính diện tích” mà không quan tâm cách tính.
//        Các lớp Circle, Rectangle ẩn chi tiết công thức, chỉ cung cấp kết quả thông qua phương thức area().
        Shape s1 = new Circle(2);
        Shape s2 = new Rectangle(3, 4);
        System.out.println(s1.area());  // 12.56…
        System.out.println(s2.area());  // 12.0
    }
}
