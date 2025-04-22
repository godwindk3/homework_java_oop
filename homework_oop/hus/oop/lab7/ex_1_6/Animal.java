package hus.oop.lab7.ex_1_6;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void greets();
}
