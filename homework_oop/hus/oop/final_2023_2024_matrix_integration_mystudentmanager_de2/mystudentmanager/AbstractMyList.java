package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.mystudentmanager;

public abstract class AbstractMyList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }
}
