//package hus.oop.midterm_2023.vector;
//
//public class BasicStatistics {
//    private MyVector[] vectors;
//
//    public static void main(String[] args) {
//        /*
//         TODO
//
//         Thực hiện các yêu cầu sau.
//
//         I. Test chức năng vector
//           - Viết các hàm testArrayVector để test các chứ năng của array vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
//             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...
//           - Viết các hàm testListVector để test các chứ năng của list vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
//             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...
//
//         II. Thực hiện thống kê đơn giản với các vector
//           - Tạo ra ít nhất 10 vector và cho vào mảng vectors để quản lý. Trong đó có ít nhất 2 nhóm các vector
//             có chuẩn bằng nhau.
//           - Tìm và in ra thông tin chuẩn nhó nhất, chuẩn lớn nhất của các vector.
//           - In ra các vector có chuẩn sắp xếp theo thứ tự tăng dần, giản dần.
//           - In ra các vector có chuẩn nằm trong một đoạn [a, b] cho trước.
//           - In ra rank của các vector theo thứ tự trong mảng vectors.
//
//         III. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
//              (ví dụ NguyenVanA_123456_Vector.txt) và nộp cùng source code.
//         */
//    }
//
//    public static void testArrayVector() {
//        /* TODO */
//    }
//
//    public static void testListVector() {
//        /* TODO */
//    }
//
//    public static void doSimpleStatic() {
//        /* TODO */
//    }
//
//    /**
//     * Lấy giá trị chuẩn lớn nhất trong các vector.
//     * @return chuẩn lớn nhất.
//     */
//    public double normMax() {
//        /* TODO */
//        return 0;
//    }
//
//    /**
//     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
//     * @return chuẩn nhỏ nhất.
//     */
//    public double normMin() {
//        /* TODO */
//        return 0;
//    }
//
//    /**
//     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
//     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
//     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
//     * @return mảng các vector theo thứ tự mảng tăng dần.
//     */
//    public MyVector[] sortNorm(boolean order) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Lọc ra mảng các vector có chuẩn năm trong đoạn [from, to].
//     * @param from
//     * @param to
//     * @return các vector có chuẩn nằm trong đoạn [from, to]
//     */
//    public MyVector[] filter(int from, int to) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
//     * Rank được tính theo quy luật sau, ví dụ
//     *   - tập [3 1 4] có rank [2.0 1.0 3.0]
//     *   - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
//     *     được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt
//     *     đầu là 1)
//     * @return
//     */
//    public double[] rank() {
//        /* TODO */
//        return null;
//    }
//}
package hus.oop.midterm_2023.vector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BasicStatistics {
    private MyVector[] vectors;

    public BasicStatistics(MyVector[] vectors) {
        this.vectors = vectors;
    }

    public static void main(String[] args) {
        // I. Test chức năng vector
        testArrayVector();
        testListVector();

        // II. Thực hiện thống kê đơn giản
        doSimpleStatic();
    }

    public static void testArrayVector() {
        System.out.println("Testing MyArrayVector:");
        MyArrayVector v1 = new MyArrayVector();
        v1.insert(1.0).insert(2.0).insert(3.0);
        System.out.println("v1: " + v1);

        v1.set(5.0, 1);
        System.out.println("After set(5.0, 1): " + v1);

        v1.insert(4.0, 1);
        System.out.println("After insert(4.0, 1): " + v1);

        v1.remove(0);
        System.out.println("After remove(0): " + v1);

        MyArrayVector v2 = new MyArrayVector();
        v2.insert(2.0).insert(3.0).insert(1.0);
        v1.add(v2);
        System.out.println("After add(v2): " + v1);

        v1.scale(2.0);
        System.out.println("After scale(2.0): " + v1);

        System.out.println("Dot product with v2: " + v1.dot(v2));
        System.out.println("Norm of v1: " + v1.norm());
        System.out.println();
    }

    public static void testListVector() {
        System.out.println("Testing MyListVector:");
        MyListVector v1 = new MyListVector();
        v1.insert(1.0).insert(2.0).insert(3.0);
        System.out.println("v1: " + v1);

        v1.set(5.0, 1);
        System.out.println("After set(5.0, 1): " + v1);

        v1.insert(4.0, 1);
        System.out.println("After insert(4.0, 1): " + v1);

        v1.remove(0);
        System.out.println("After remove(0): " + v1);

        MyListVector v2 = new MyListVector();
        v2.insert(2.0).insert(3.0).insert(1.0);
        v1.add(v2);
        System.out.println("After add(v2): " + v1);

        v1.scale(2.0);
        System.out.println("After scale(2.0): " + v1);

        System.out.println("Dot product with v2: " + v1.dot(v2));
        System.out.println("Norm of v1: " + v1.norm());
        System.out.println();
    }

    public static void doSimpleStatic() {
        // Tạo 10 vector với ít nhất 2 nhóm có chuẩn bằng nhau
        MyVector[] vectors = new MyVector[10];
        vectors[0] = new MyArrayVector().insert(1.0).insert(0.0); // norm = 1
        vectors[1] = new MyArrayVector().insert(0.0).insert(1.0); // norm = 1
        vectors[2] = new MyArrayVector().insert(2.0).insert(0.0); // norm = 2
        vectors[3] = new MyArrayVector().insert(0.0).insert(2.0); // norm = 2
        vectors[4] = new MyArrayVector().insert(3.0).insert(4.0); // norm = 5
        vectors[5] = new MyListVector().insert(5.0).insert(0.0); // norm = 5
        vectors[6] = new MyArrayVector().insert(1.0).insert(2.0).insert(2.0); // norm = 3
        vectors[7] = new MyListVector().insert(6.0).insert(8.0); // norm = 10
        vectors[8] = new MyArrayVector().insert(0.0).insert(10.0); // norm = 10
        vectors[9] = new MyListVector().insert(1.0).insert(1.0).insert(1.0); // norm ≈ 1.732

        BasicStatistics stats = new BasicStatistics(vectors);

        // Tìm chuẩn nhỏ nhất và lớn nhất
        double minNorm = stats.normMin();
        double maxNorm = stats.normMax();
        System.out.println("Min norm: " + minNorm);
        System.out.println("Max norm: " + maxNorm);

        // Sắp xếp theo chuẩn
        MyVector[] sortedAsc = stats.sortNorm(true);
        MyVector[] sortedDesc = stats.sortNorm(false);
        System.out.println("Sorted ascending by norm: " + Arrays.toString(sortedAsc));
        System.out.println("Sorted descending by norm: " + Arrays.toString(sortedDesc));

        // Lọc vector trong đoạn [2, 5]
        MyVector[] filtered = stats.filter(2, 5);
        System.out.println("Vectors with norm in [2, 5]: " + Arrays.toString(filtered));

        // Tính rank
        double[] ranks = stats.rank();
        System.out.println("Ranks: " + Arrays.toString(ranks));

        // Lưu vào file
        try (PrintWriter writer = new PrintWriter(new FileWriter("NguyenVanA_123456_Vector.txt"))) {
            writer.println("Min norm: " + minNorm);
            writer.println("Max norm: " + maxNorm);
            writer.println("Sorted ascending by norm: " + Arrays.toString(sortedAsc));
            writer.println("Sorted descending by norm: " + Arrays.toString(sortedDesc));
            writer.println("Vectors with norm in [2, 5]: " + Arrays.toString(filtered));
            writer.println("Ranks: " + Arrays.toString(ranks));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     * @return chuẩn lớn nhất
     */
    public double normMax() {
        double maxNorm = Double.MIN_VALUE;
        for (MyVector vector : vectors) {
            double norm = vector.norm();
            if (norm > maxNorm) {
                maxNorm = norm;
            }
        }
        return maxNorm;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     * @return chuẩn nhỏ nhất
     */
    public double normMin() {
        double minNorm = Double.MAX_VALUE;
        for (MyVector vector : vectors) {
            double norm = vector.norm();
            if (norm < minNorm) {
                minNorm = norm;
            }
        }
        return minNorm;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * @param order true để tăng dần, false để giảm dần
     * @return mảng các vector đã sắp xếp
     */
    public MyVector[] sortNorm(boolean order) {
        MyVector[] sortedVectors = Arrays.copyOf(vectors, vectors.length);
        Arrays.sort(sortedVectors, new Comparator<MyVector>() {
            @Override
            public int compare(MyVector v1, MyVector v2) {
                double norm1 = v1.norm();
                double norm2 = v2.norm();
                return order ? Double.compare(norm1, norm2) : Double.compare(norm2, norm1);
            }
        });
        return sortedVectors;
    }

    /**
     * Lọc ra mảng các vector có chuẩn nằm trong đoạn [from, to].
     * @param from giá trị nhỏ nhất
     * @param to giá trị lớn nhất
     * @return các vector thỏa mãn
     */
    public MyVector[] filter(int from, int to) {
        return Arrays.stream(vectors)
                .filter(vector -> vector.norm() >= from && vector.norm() <= to)
                .toArray(MyVector[]::new);
    }

    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * @return mảng rank
     */
    public double[] rank() {
        double[] norms = Arrays.stream(vectors).mapToDouble(MyVector::norm).toArray();
        double[] sortedNorms = Arrays.copyOf(norms, norms.length);
        Arrays.sort(sortedNorms);
        double[] ranks = new double[norms.length];
        for (int i = 0; i < norms.length; i++) {
            int count = 0;
            double sum = 0;
            for (int j = 0; j < sortedNorms.length; j++) {
                if (sortedNorms[j] == norms[i]) {
                    sum += (j + 1);
                    count++;
                }
            }
            ranks[i] = sum / count;
        }
        return ranks;
    }
}
