package hus.oop.midterm_2023.oop_principles.polymorphism.overriding;

// Định nghĩa: Cùng một tên phương thức, nhưng hành vi khác nhau tùy đối tượng (runtime).
// Có hai dạng chính: Overriding (ghi đè) và Overloading (nạp chồng).

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        a1.sound();  // Meo meo
        a2.sound();  // Gâu gâu
    }
}
