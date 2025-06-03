//package hus.oop.midterm_2023.vector;
//
//public abstract class AbstractMyVector implements MyVector {
//    /**
//     * Mô tả vector theo định dạng [a1 a2 ... an]
//     * @return
//     */
//    @Override
//    public String toString() {
//        /* TODO */
//        return "";
//    }
//
//    /**
//     * So sánh hai vector có bằng nhau không.
//     * Hai vector bằng nhau nếu có cùng số chiều và có tọa độ bằng nhau.
//     * @param another
//     * @return
//     */
//    @Override
//    public boolean equals(MyVector another) {
//        /* TODO */
//        return false;
//    }
//}
package hus.oop.midterm_2022_2023_principles_vector_student.vector;

public abstract class AbstractMyVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return chuỗi biểu diễn vector
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(coordinate(i));
            if (i < size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng số chiều và có tọa độ bằng nhau.
     * @param another vector khác để so sánh
     * @return true nếu bằng nhau, false nếu không
     */
    @Override
    public boolean equals(MyVector another) {
        if (this.size() != another.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (this.coordinate(i) != another.coordinate(i)) {
                return false;
            }
        }
        return true;
    }
}