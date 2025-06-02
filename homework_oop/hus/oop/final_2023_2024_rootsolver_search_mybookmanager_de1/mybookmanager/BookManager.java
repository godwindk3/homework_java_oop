package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.mybookmanager;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        /* TODO */
        this.bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     *
     * @param book
     */
    public void insertAtStart(Book book) {
        /* TODO */
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     *
     * @param book
     */
    public void insertAtEnd(Book book) {
        /* TODO */
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     *
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        /* TODO */
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     *
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     *
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        MyIterator it = bookList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (i == index) {
                return b;
            }
            i++;
        }
        return null;
    }

    /**
     * Lấy ra sách có giá cao nhất.
     *
     * @return
     */
    public Book highestPriceBook() {
        MyIterator it = bookList.iterator();
        if (!it.hasNext()) return null;
        Book maxBook = (Book) it.next();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getPrice() > maxBook.getPrice()) {
                maxBook = b;
            }
        }
        return maxBook;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     *
     * @return
     */
    public Book lowestPriceBook() {
        MyIterator it = bookList.iterator();
        if (!it.hasNext()) return null;
        Book minBook = (Book) it.next();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getPrice() < minBook.getPrice()) {
                minBook = b;
            }
        }
        return minBook;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     *
     * @return
     */
    public Book highestNumberOfPagesBook() {
        MyIterator it = bookList.iterator();
        if (!it.hasNext()) return null;
        Book maxBook = (Book) it.next();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getPages() > maxBook.getPages()) {
                maxBook = b;
            }
        }
        return maxBook;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     *
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        MyIterator it = bookList.iterator();
        if (!it.hasNext()) return null;
        Book minBook = (Book) it.next();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getPages() < minBook.getPages()) {
                minBook = b;
            }
        }
        return minBook;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     *
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getPublisher().equalsIgnoreCase(publisher)) {
                result.insertAtEnd(b);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo thể loại.
     *
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getGenre().equalsIgnoreCase(genre)) {
                result.insertAtEnd(b);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo tác giả.
     *
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.insertAtEnd(b);
            }
        }
        return result;
    }
}
