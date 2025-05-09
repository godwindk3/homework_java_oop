package hus.oop.lab11.visitor_pattern.book;

public interface Visitor {
    void visit(BusinessBook book);
    void visit(DesignPatternBook book);
    void visit(JavaCoreBook book);
}
