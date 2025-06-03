package hus.oop.midterm_2022_2023_principles_vector_student.oop_principles.polymorphism.overriding;

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meo meo");
    }
}