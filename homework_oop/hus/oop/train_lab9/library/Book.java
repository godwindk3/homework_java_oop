package hus.oop.train_lab9.library;

public class Book extends Item {
    int pages;

    public Book(String title, int year, int pages) {
        super(title, year);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        return "Book[" + "pages=" + this.pages
                + ", title=" + this.title + "\""
                + ", year=" + this.year + "]";

    }
}
