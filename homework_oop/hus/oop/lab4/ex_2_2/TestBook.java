package hus.oop.lab4.ex_2_2;

public class TestBook {
    public static void main(String[] args) {
        Author[] authors = new Author[2];
        authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.come", 'm');
        authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

        Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
        System.out.println(javaDummy);
        System.out.println(javaDummy.getAuthorNames());
    }
}
