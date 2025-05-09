package hus.oop.lab11.visitor_pattern.book;

public class DesignPatternBook extends ProgramingBook {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getResource() {
        return "This is Design Pattern Book";
    }

    public String getBestseller() {
        return "Visitor Pattern Book";
    }

}
