package hus.oop.lab7.ex_1_7;


public class TestAnimal {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.greeting();
        Dog dog1 = new Dog();
        dog1.greeting();
        BigDog bigDog1 = new BigDog();
        bigDog1.greeting();

        Animal animal1 = new Cat(); // Upcasting, because Cat is an animal
        animal1.greeting();
        Animal animal2 = new Dog(); // Upcasting, because Dog is an animal
        animal2.greeting();
        Animal animal3 = new BigDog(); // Upcasting, because BigDog is an animal
        animal3.greeting();
//        Animal animal4 = new Animal(); // Animal is an abstract class

        Dog dog2 = (Dog) animal2; // Downcasting
        BigDog bigDog2 = (BigDog) animal3; // Downcasting
        Dog dog3 = (Dog) animal3; //
//        Cat cat2 = (Cat) animal2; // Dog cannot be cast to Cat
        dog2.greeting(dog3);
        dog3.greeting(dog2);
        dog2.greeting(bigDog2); // bigDog2 is also a Dog
        bigDog2.greeting(dog2);
        bigDog2.greeting(bigDog1);
    }
}
