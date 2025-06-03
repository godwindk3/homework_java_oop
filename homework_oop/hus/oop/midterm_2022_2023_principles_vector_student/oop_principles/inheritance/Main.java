package hus.oop.midterm_2022_2023_principles_vector_student.oop_principles.inheritance;

//Định nghĩa: Lớp con (subclass) kế thừa thuộc tính và phương thức của lớp cha (superclass), tái sử dụng và mở rộng.

public class Main {
    public static void main(String[] args) {
//        Dog tự động có eat() từ Animal mà không cần viết lại.
//        Giúp tái sử dụng mã và xây dựng quan hệ “là một” (Dog là một Animal).
        Dog d = new Dog();
        d.eat();   // thừa hưởng phương thức eat()
        d.bark();  // phương thức riêng
    }
}
