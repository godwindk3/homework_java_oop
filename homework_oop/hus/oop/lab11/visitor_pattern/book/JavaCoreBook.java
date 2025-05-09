package hus.oop.lab11.visitor_pattern.book;

public class JavaCoreBook extends ProgramingBook {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getResource() {
        return "This is JavaCore Book";
    }

    public String getFavouriteBook() {
        return "Sorting Method";
    }
}
