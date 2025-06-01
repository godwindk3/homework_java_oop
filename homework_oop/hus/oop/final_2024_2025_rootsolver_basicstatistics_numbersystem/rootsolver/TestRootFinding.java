package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem.rootsolver;
import java.io.PrintWriter;
public class TestRootFinding {
    public static void main(String[] args) {
        /* TODO
        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootSolver>.txt
        (ví dụ, NguyenVanA_123456_RootSolver.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootSolver>.zip (ví dụ, NguyenVanA_123456_RootSolver.txt), và nộp bài
        lên classroom.
        */

        // Tự do điều chỉnh [lower, upper], tolerance, maxIterations
        testRootSolver();

    }

    public static void testRootSolver() {
        /* TODO
         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm có thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm tìm được trong khoảng [a, b] đã cho.
         */
        try {
            PrintWriter writer = new PrintWriter("BuiNguyenPhong_21002165_RootSolver.txt", "UTF-8");
            AbstractFunction function = new UnivariateRealFunction();
            UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function);
            double lower = 0.0; // Mở rộng khoảng để đổi dấu
            double upper = 5.0;
            double tolerance = 1.0E-6;
            int maxIterations = 100;

            // Test Bisection
            writer.println("=== Phương pháp Bisection ===");
            rootFinding.setRootSolver(new BisectionSolver(tolerance, maxIterations));
            try {
                double root = rootFinding.solve(lower, upper);
                writer.println("Hàm: f(x) = x * sin(x) - 3");
                writer.println("Nghiệm: x = " + root);
                writer.println("Giá trị hàm tại nghiệm: f(" + root + ") = " + function.evaluate(root));
            } catch (Exception e) {
                writer.println("Lỗi: " + e.getMessage());
            }

            // Test Newton-Raphson
            writer.println("\n=== Phương pháp Newton-Raphson ===");
            rootFinding.setRootSolver(new NewtonRaphsonSolver(tolerance, maxIterations));
            try {
                double root = rootFinding.solve(lower, upper);
                writer.println("Hàm: f(x) = x * sin(x) - 3");
                writer.println("Nghiệm: x = " + root);
                writer.println("Giá trị hàm tại nghiệm: f(" + root + ") = " + function.evaluate(root));
                writer.println("Giá trị đạo hàm tại nghiệm: f'(" + root + ") = " + function.derivative(root));
            } catch (Exception e) {
                writer.println("Lỗi: " + e.getMessage());
            }

            // Test Secant
            writer.println("\n=== Phương pháp Secant ===");
            rootFinding.setRootSolver(new SecantSolver(tolerance, maxIterations));
            try {
                double root = rootFinding.solve(lower, upper);
                writer.println("Hàm: f(x) = x * sin(x) - 3");
                writer.println("Nghiệm: x = " + root);
                writer.println("Giá trị hàm tại nghiệm: f(" + root + ") = " + function.evaluate(root));
            } catch (Exception e) {
                writer.println("Lỗi: " + e.getMessage());
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
