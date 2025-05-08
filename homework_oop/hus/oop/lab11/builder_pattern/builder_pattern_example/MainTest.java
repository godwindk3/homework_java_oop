package hus.oop.lab11.builder_pattern.builder_pattern_example;

public class MainTest {
    public static void main(String[] args) {
        Sandwich mySandwich = new Sandwich.Builder().bread("Wheat").meat("Turkey").cheese("Cheddar").build();
        System.out.println(mySandwich);
    }
}
