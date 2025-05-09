package hus.oop.lab11.abstract_factory_pattern.example;

public class VintageFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VintageChair();
    }

    @Override
    public Table createTable() {
        return new VintageTable();
    }
}
