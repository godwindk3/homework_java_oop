package hus.oop.lab11.visitor_pattern.book;

public class VisitorPatternExample {
    public static void main(String[] args) {
        Visitor visitor = new VisitorImpl();

        BusinessBook businessBook = new BusinessBook();
        ProgramingBook designPatternBook = new DesignPatternBook();
        ProgramingBook javaCoreBook = new JavaCoreBook();

        businessBook.accept(visitor);
        System.out.println();

        designPatternBook.accept(visitor);
        System.out.println();

        javaCoreBook.accept(visitor);
        System.out.println();
    }
}
