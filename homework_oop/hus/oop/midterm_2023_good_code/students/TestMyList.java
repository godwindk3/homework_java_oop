package hus.oop.midterm_2023_good_code.students;

public class TestMyList {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
           (ví dụ, NguyenVanA_123456_MyList.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testMyArrayList();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         TODO

         - Tạo ra một list kiểu MyArrayList có ít nhất 10 Student.

         - Sử dụng StudentStatistics để
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần về average.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần về average.
         */
        MyList studentList = new MyArrayList();
        studentList.append(new Student("C", "Le", 6.9));
        studentList.append(new Student("D", "Pham", 9.1));
        studentList.append(new Student("E", "Bui", 7.7));
        studentList.append(new Student("F", "Hoang", 8.2));
        studentList.append(new Student("G", "Nguyen", 6.5));
        studentList.append(new Student("A", "Nguyen", 8.5));
        studentList.append(new Student("B", "Tran", 7.3));
        studentList.append(new Student("H", "Vu", 9.5));
        studentList.append(new Student("I", "Dang", 7.0));
        studentList.append(new Student("J", "Do", 8.0));
        // Tạo đối tượng StudentStatistics
        StudentStatistics statistics = new StudentStatistics(studentList);

        // Sắp xếp và in ra theo tên và họ (tăng dần)
        System.out.println("Sắp xếp theo tên và họ (tăng dần):");
        MyList sortedByFullnameAsc = statistics.sortByFullname(true);
        testIterator(sortedByFullnameAsc);

        // Sắp xếp và in ra theo tên và họ (giảm dần)
        System.out.println("\nSắp xếp theo tên và họ (giảm dần):");
        MyList sortedByFullnameDesc = statistics.sortByFullname(false);
        testIterator(sortedByFullnameDesc);

        // Sắp xếp và in ra theo average (tăng dần)
        System.out.println("\nSắp xếp theo average (tăng dần):");
        MyList sortedByAverageAsc = statistics.sortByAverage(true);
        testIterator(sortedByAverageAsc);

        // Sắp xếp và in ra theo average (giảm dần)
        System.out.println("\nSắp xếp theo average (giảm dần):");
        MyList sortedByAverageDesc = statistics.sortByAverage(false);
        testIterator(sortedByAverageDesc);
    }

    public static void testMyLinkedList() {
        /*
         TODO

         - Tạo ra một list kiểu MyLinkedList có ít nhất 10 Student.

         - Sử dụng StudentStatistics để
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần về average.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần về average.
         */
        // Tạo danh sách MyLinkedList với 10 sinh viên
        MyList studentList = new MyLinkedList();
        studentList.append(new Student("Nguyen", "A", 8.5));
        studentList.append(new Student("Tran", "B", 7.3));
        studentList.append(new Student("Le", "C", 6.9));
        studentList.append(new Student("Pham", "D", 9.1));
        studentList.append(new Student("Bui", "E", 7.7));
        studentList.append(new Student("Hoang", "F", 8.2));
        studentList.append(new Student("Nguyen", "G", 6.5));
        studentList.append(new Student("Vu", "H", 9.5));
        studentList.append(new Student("Dang", "I", 7.0));
        studentList.append(new Student("Do", "J", 8.0));

        // Tạo đối tượng StudentStatistics
        StudentStatistics statistics = new StudentStatistics(studentList);

        // Sắp xếp và in ra theo tên và họ (tăng dần)
        System.out.println("Sắp xếp theo tên và họ (tăng dần):");
        MyList sortedByFullnameAsc = statistics.sortByFullname(true);
        testIterator(sortedByFullnameAsc);

        // Sắp xếp và in ra theo tên và họ (giảm dần)
        System.out.println("\nSắp xếp theo tên và họ (giảm dần):");
        MyList sortedByFullnameDesc = statistics.sortByFullname(false);
        testIterator(sortedByFullnameDesc);

        // Sắp xếp và in ra theo average (tăng dần)
        System.out.println("\nSắp xếp theo average (tăng dần):");
        MyList sortedByAverageAsc = statistics.sortByAverage(true);
        testIterator(sortedByAverageAsc);

        // Sắp xếp và in ra theo average (giảm dần)
        System.out.println("\nSắp xếp theo average (giảm dần):");
        MyList sortedByAverageDesc = statistics.sortByAverage(false);
        testIterator(sortedByAverageDesc);
    }

    public static void testIterator(MyList myList) {
        /*
         TODO

         Sử dụng iterator duyệt qua tất cả các phần tử trong danh sách myList và in ra thông tin về phần tử đó.
         */
        MyIterator iterator = myList.iterator();

        // Duyệt qua tất cả các phần tử trong myList và in ra thông tin
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
    }
}
