package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */
        System.out.println("=== TEST ORIGINAL DATA ===");
        testOriginalData();

        System.out.println("\n=== TEST FILTER BY AUTHOR ===");
        testFilterBooksOfAuthor();

        System.out.println("\n=== TEST FILTER BY PUBLISHER ===");
        testFilterBooksOfPublisher();

        System.out.println("\n=== TEST FILTER BY GENRE ===");
        testFilterBooksOfGenre();

        System.out.println("\n=== TEST HIGHEST PRICE BOOK ===");
        testGetHighestPriceBook();

        System.out.println("\n=== TEST LOWEST PRICE BOOK ===");
        testGetLowestPriceBook();

        System.out.println("\n=== TEST HIGHEST PAGES BOOK ===");
        testGetHighestNumberOfPagesBook();

        System.out.println("\n=== TEST LOWEST PAGES BOOK ===");
        testGetLowestNumberOfPagesBook();
    }

    public static void init() {
        String filePath = "homework_oop\\hus\\oop\\final_2023_2024_rootsolver_search_mybookmanager_de1\\data\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                // Tạo Book bằng Builder Pattern
                String title = dataList.get(0).trim();
                String author = dataList.get(1).trim();
                String genre = dataList.get(2).trim();
                int pages = Integer.parseInt(dataList.get(3).trim());
                double price = Double.parseDouble(dataList.get(4).trim());
                String publisher = dataList.get(5).trim();

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(price)
                        .withPublisher(publisher)
                        .build();

                // Thêm vào BookManager
                BookManager.getInstance().insertAtEnd(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        MyList allBooks = BookManager.getInstance().getBookList();
        MyIterator it = allBooks.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        String author = "J.K. Rowling";
        MyList filtered = BookManager.getInstance().filterBooksOfAuthor(author);
        System.out.println("Books của tác giả: " + author);
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        String publisher = "Penguin";
        MyList filtered = BookManager.getInstance().filterBooksOfPublisher(publisher);
        System.out.println("Books của publisher: " + publisher);
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        String genre = "Fantasy";
        MyList filtered = BookManager.getInstance().filterBooksOfGenre(genre);
        System.out.println("Books thể loại: " + genre);
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook() {
        Book highest = BookManager.getInstance().highestPriceBook();
        if (highest != null) {
            System.out.println("Sách có giá cao nhất:\n" + highest);
        } else {
            System.out.println("Không tìm thấy sách nào.");
        }
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook() {
        Book lowest = BookManager.getInstance().lowestPriceBook();
        if (lowest != null) {
            System.out.println("Sách có giá thấp nhất:\n" + lowest);
        } else {
            System.out.println("Không tìm thấy sách nào.");
        }
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook() {
        Book highestPages = BookManager.getInstance().highestNumberOfPagesBook();
        if (highestPages != null) {
            System.out.println("Sách có số trang nhiều nhất:\n" + highestPages);
        } else {
            System.out.println("Không tìm thấy sách nào.");
        }
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook() {
        Book lowestPages = BookManager.getInstance().lowestNumberOfPagesBook();
        if (lowestPages != null) {
            System.out.println("Sách có số trang ít nhất:\n" + lowestPages);
        } else {
            System.out.println("Không tìm thấy sách nào.");
        }
    }
}
