package hus.oop.lab11.factory_method.fruit;

public class FruitFactory {

    public static Fruit provideFruit(String type) {
        if (type.equalsIgnoreCase("orange")) {
            return new Orange();
        } else if (type.equalsIgnoreCase("banana")) {
            return new Banana();
        } else if (type.equalsIgnoreCase("apple")) {
            return new Apple();
        } else {
            throw  new IllegalArgumentException("Unknown fruit");
        }

    }
}
