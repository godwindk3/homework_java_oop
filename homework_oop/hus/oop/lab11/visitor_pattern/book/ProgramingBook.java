package hus.oop.lab11.visitor_pattern.book;

public class ProgramingBook implements Book {


    @Override
    public void accept(Visitor v) {

    }

    public String getResource() {
        return "This is Programing Book";
    }
}
