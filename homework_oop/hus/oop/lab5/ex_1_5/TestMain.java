package hus.oop.lab5.ex_1_5;

public class TestMain {
    public static void main(String[] args) {
        // Test Animal
        Animal animal = new Animal("Generic Animal");
        System.out.println(animal);

        // Test Mammal
        Mammal mammal = new Mammal("Generic Mammal");
        System.out.println(mammal);

        // Test Cat
        Cat cat = new Cat("Tom");
        System.out.println(cat);
        cat.greets();

        // Test Dog
        Dog dog1 = new Dog("Rex");
        Dog dog2 = new Dog("Max");
        System.out.println(dog1);
        dog1.greets();           // Gọi greets() đơn
        dog1.greets(dog2);       // Gọi greets(Dog another)

        //
        Mammal mammalCat = new Cat("Kitty");
        System.out.println(mammalCat);
    }
}
