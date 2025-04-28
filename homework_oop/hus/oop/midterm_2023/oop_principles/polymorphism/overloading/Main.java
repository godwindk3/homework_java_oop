package hus.oop.midterm_2023.oop_principles.polymorphism.overloading;

// Cùng tên add(), nhưng Java chọn phương thức phù hợp dựa trên tham số.
public class Main {
    public static void main(String[] args) {
        MathUtil m = new MathUtil();
        System.out.println(m.add(2, 3));      // 5
        System.out.println(m.add(2.5, 3.1));  // 5.6
    }
}
