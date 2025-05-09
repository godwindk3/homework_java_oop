package hus.oop.lab11.visitor_pattern.book;


public interface Book {
    void accept(Visitor v);
}
