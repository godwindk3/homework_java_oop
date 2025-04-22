package hus.oop.lab7.ex_1_6;

public class TestMain {
    public static void main(String[] args) {

        Cat cat = new Cat("Tom");
        Dog dog1 = new Dog("Max");
        Dog dog2 = new Dog("Buddy");
        BigDog bigDog1 = new BigDog("Rex");
        BigDog bigDog2 = new BigDog("King");


        System.out.println("Testing basic greets:");
        cat.greets();           // Meow
        dog1.greets();          // Woof
        bigDog1.greets();       // Wooow

        System.out.println("\nTesting Dog interactions:");

        dog1.greets(dog2);      // Woooof (Dog greets Dog)
        dog1.greets(bigDog1);   // Woooof (Dog greets BigDog - BigDog is also Dog)

        System.out.println("\nTesting BigDog interactions:");

        bigDog1.greets(dog1);   // Woooooow (BigDog greets Dog)
        bigDog1.greets(bigDog2); // Woooooooooow (BigDog greets BigDog)
    }
}
