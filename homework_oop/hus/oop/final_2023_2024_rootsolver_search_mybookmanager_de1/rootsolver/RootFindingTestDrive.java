package hus.oop.final_2023_2024_rootsolver_search_mybookmanager_de1.rootsolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        try {
            PrintStream out = new PrintStream(new File("NguyenVanA_123456_RootFinding.txt"));
            System.setOut(out);
            testRootSolver();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void testRootSolver() {
        /*
         TODO

         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */
        AbstractFunction function = new UnivariateRealFunction();
        UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function);

        RootSolver[] solvers = {
                new BisectionSolver(1e-6, 100),
                new NewtonRaphsonSolver(1e-6, 100),
                new SecantSolver(1e-6, 100)
        };
        String[] methodNames = {"Bisection", "Newton-Raphson", "Secant"};

        double lower = 0;
        double upper = 5;

        for (int i = 0; i < solvers.length; i++) {
            rootFinding.setRootSolver(solvers[i]);
            try {
                double root = rootFinding.solve(lower, upper);
                System.out.println("Phương pháp: " + methodNames[i]);
                System.out.println("Hàm: sin(x)*x - 3");
                System.out.println("Nghiệm: " + root);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Phương pháp: " + methodNames[i]);
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println();
            }
        }
    }
}
