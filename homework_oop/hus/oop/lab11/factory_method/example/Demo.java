package hus.oop.lab11.factory_method.example;

public class Demo {
    public static void main(String[] args) {
        Drink coffee = DrinkFactory.createDrink("coffee");
        Drink tea = DrinkFactory.createDrink("tea");

        coffee.serve();
        tea.serve();
    }
}
