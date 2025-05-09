package hus.oop.lab11.abstract_factory_pattern.example;

public class Client {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        System.out.println("Modern set: " + modernChair.getStyle() + ", " + modernTable.getStyle());

        FurnitureFactory vintageFactory = new VintageFurnitureFactory();
        Chair vintageChair = vintageFactory.createChair();
        Table vintageTable = vintageFactory.createTable();
        System.out.println("Vintage set: " + vintageChair.getStyle() + ", " + vintageTable.getStyle());
    }
}
