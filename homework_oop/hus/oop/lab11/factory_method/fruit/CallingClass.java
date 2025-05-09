package hus.oop.lab11.factory_method.fruit;

public class CallingClass {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.provideFruit("apple");
        Fruit banana = FruitFactory.provideFruit("BANANA");
        Fruit orange = FruitFactory.provideFruit("OrAnGe");

        apple.produceJuice();
        banana.produceJuice();
        orange.produceJuice();
    }
}
