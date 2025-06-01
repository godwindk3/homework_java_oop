package hus.oop.temporary.book;

import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        /* TODO */
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAtPosition(Book book, int index) {
        /* TODO */
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return null;
    }

    /**
     * Trả ra số book trong danh sách.
     * @return
     */
    public int numberOfBooks() {
        /* TODO */
        return 1;
    }

    /**
     * Tổng giá của tất cả các book.
     * @return
     */
    public double totalPrice() {
        /* TODO */
        return 0;
    }

    /**
     * Tổng số trang của tất cả các book.
     * @return
     */
    public double totalPages() {
        /* TODO */
        return 0;
    }

    /**
     * Trả ra danh sách book theo thứ tự tăng dần theo title.
     * @return
     */
    public List<Book> sortIncreasingByTitle() {
        /* TODO */
        return null;
    }

    /**
     * Trả ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortByPublisherAndPrice() {
        /* TODO */
        return null;
    }

    /**
     * Trả ra danh sách book sắp xếp theo giá tăng dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        return null;
    }

    /**
     * Trả ra danh sách book theo giá giảm dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        return null;
    }

    /**
     * Trả ra danh sách book theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        return null;
    }

    /**
     * Trả ra danh sách book theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        return null;
    }

    /**
     * Trả ra danh sách book theo publisher.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        return null;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
