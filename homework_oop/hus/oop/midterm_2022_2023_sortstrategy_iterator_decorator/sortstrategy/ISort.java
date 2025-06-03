package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.sortstrategy;

public interface ISort {
    // Phương thức sắp xếp dữ liệu data theo thứ tự tăng dần,
    // Đầu vào là mảng dữ liệu, đầu ra là số lần thực hiện đổi chỗ dữ liệu.
    public abstract int sort(int[] data);
}
