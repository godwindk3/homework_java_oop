package hus.oop.final_2023_2024_fraction_basicstatistics_integration_de1.basicstatistics;

public interface MyIterator {
    /**
     * Kiểm tra xem danh sách có còn phần tử tiếp theo không.
     * @return true nếu còn, false nếu không còn.
     */
    boolean hasNext();

    /**
     * iterator dịch chuyển sang phần tử kế tiếp của dánh sách và trả ra phần tử hiện tại.
     * @return
     */
    Object next();

    /**
     * Xóa phần tử hiện tại của danh sách.
     */
    void remove();
}
