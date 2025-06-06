package hus.oop.midterm_2023_good_code.students;

public interface MyIterator {
    /**
     * Kiểm tra xem list có còn phần tử tiếp theo không.
     * @return true nếu còn, false nếu không còn.
     */
    boolean hasNext();

    /**
     * iterator dịch chuyển sang phần tử kế tiếp của list và trả ra phần tử hiện tại.
     * @return
     */
    Object next();
}
