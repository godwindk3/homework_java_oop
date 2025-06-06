package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.search;

public interface Search {
    /**
     * Tìm kiếm trong mảng có giá trị value không.
     * @param data: mảng tập hợp các giá trị.
     * @param value: giá trị cần tìm kiếm.
     * @return chỉ số của value trong mảng, -1 nếu không tìm thấy.
     */
    int search(double[] data, double value);
}
