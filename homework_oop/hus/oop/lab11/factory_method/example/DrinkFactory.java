package hus.oop.lab11.factory_method.example;

public class DrinkFactory {
    public static Drink createDrink(String type) {
        if (type.equalsIgnoreCase("Coffee")) {
            return new Coffee();
        } else if (type.equalsIgnoreCase("Tea")) {
            return new Tea();
        } else {
            throw new IllegalArgumentException("Unknown drink type");
        }
    }
}
