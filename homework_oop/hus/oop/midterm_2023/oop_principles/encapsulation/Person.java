package hus.oop.midterm_2023.oop_principles.encapsulation;

public class Person {
                            // Thuộc tính name/age được khai báo private để bên ngoài không truy cập trực tiếp.
    private String name;    // thuộc tính bị ẩn
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 0) this.age = age;  // kiểm tra hợp lệ
    }
}
