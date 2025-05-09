package hus.oop.lab11.visitor_pattern.book;

public class BusinessBook implements Book{

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public String getPublisher() {
        return "This is  publisher of business book";
    }
}
