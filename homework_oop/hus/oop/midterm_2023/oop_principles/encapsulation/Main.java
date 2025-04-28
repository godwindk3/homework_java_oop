package hus.oop.midterm_2023.oop_principles.encapsulation;

public class Main {
    public static void main(String[] args) {

//        Định nghĩa: Đóng gói dữ liệu (thuộc tính) và phương thức thao tác lên dữ liệu đó vào cùng một lớp, đồng thời che giấu (private)
//        các chi tiết bên trong, chỉ cho phép truy cập qua các phương thức công khai (getter/setter).
        Person p = new Person();
        p.setName("An");    // dùng setter
        p.setAge(-5);       // setter chặn giá trị không hợp lệ
        System.out.println(p.getName() + ", " + p.getAge());  // An, 0
    }
}
