package hus.oop.midterm_2023.oop_principles.polymorphism.overriding;

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meo meo");
    }
}