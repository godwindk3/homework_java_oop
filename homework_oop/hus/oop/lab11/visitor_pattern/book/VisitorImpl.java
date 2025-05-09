package hus.oop.lab11.visitor_pattern.book;

public class VisitorImpl implements Visitor {


    @Override
    public void visit(BusinessBook book) {
        System.out.println(book.getPublisher());
    }

    @Override
    public void visit(DesignPatternBook book) {
        System.out.println(book.getResource());
        System.out.println("Best seller: " + book.getBestseller());
    }

    @Override
    public void visit(JavaCoreBook book) {
        System.out.println(book.getResource());
        System.out.println("Best favourite: " + book.getFavouriteBook());
    }
}
