package hus.oop.midterm_2023.vector;

public class BasicStatistics {
    private MyVector[] vectors;

    public static void main(String[] args) {
        /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Viết các hàm testArrayVector để test các chứ năng của array vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...
           - Viết các hàm testListVector để test các chứ năng của list vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...

         II. Thực hiện thống kê đơn giản với các vector
           - Tạo ra ít nhất 10 vector và cho vào mảng vectors để quản lý. Trong đó có ít nhất 2 nhóm các vector
             có chuẩn bằng nhau.
           - Tìm và in ra thông tin chuẩn nhó nhất, chuẩn lớn nhất của các vector.
           - In ra các vector có chuẩn sắp xếp theo thứ tự tăng dần, giản dần.
           - In ra các vector có chuẩn nằm trong một đoạn [a, b] cho trước.
           - In ra rank của các vector theo thứ tự trong mảng vectors.

         III. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt) và nộp cùng source code.
         */
    }

    public static void testArrayVector() {
        /* TODO */
    }

    public static void testListVector() {
        /* TODO */
    }

    public static void doSimpleStatic() {
        /* TODO */
    }

    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     * @return chuẩn lớn nhất.
     */
    public double normMax() {
        /* TODO */
        return 0;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     * @return chuẩn nhỏ nhất.
     */
    public double normMin() {
        /* TODO */
        return 0;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
     * @return mảng các vector theo thứ tự mảng tăng dần.
     */
    public MyVector[] sortNorm(boolean order) {
        /* TODO */
        return null;
    }

    /**
     * Lọc ra mảng các vector có chuẩn năm trong đoạn [from, to].
     * @param from
     * @param to
     * @return các vector có chuẩn nằm trong đoạn [from, to]
     */
    public MyVector[] filter(int from, int to) {
        /* TODO */
        return null;
    }

    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * Rank được tính theo quy luật sau, ví dụ
     *   - tập [3 1 4] có rank [2.0 1.0 3.0]
     *   - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
     *     được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt
     *     đầu là 1)
     * @return
     */
    public double[] rank() {
        /* TODO */
        return null;
    }
}
