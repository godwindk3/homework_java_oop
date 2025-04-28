package hus.oop.midterm_2023_good_code.students;

public class StudentStatistics {
    private MyList students;

    /**
     * Khởi tạo dữ liệu cho StudentManager.
     */
    public StudentStatistics(MyList data) {
        /* TODO */
        students = data;
    }

    /**
     * Lấy ra danh sách các sinh viên được sắp xếp theo thứ tự phụ thuộc vào tên và họ.
     * Chú ý, không thay đổi thứ tự sinh viên trong danh sách gốc.
     *
     * @param order
     * @return danh sách các sinh viên đã được sắp xếp
     */
    public MyList sortByFullname(boolean order) {
        /*
         TODO

         - Sửa lại lớp Student để sử dụng MyComparable để thực hiện việc so sánh các Student theo tên và họ.
           Thứ tự đầu tiên phụ thuộc vào tên, nếu tên bằng nhau thì thứ tự phụ thuộc vào họ.

         - Sử dụng tiêu chí so sánh trong MyComparable, viết code để sắp xếp danh sách các sinh viên theo thứ tự
           phụ thuộc tham số order. Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì
           sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách sinh viên mới đã được sắp thứ tự.
         */
        MyList sortedList = new MyLinkedList(); // Hoặc MyArrayList

        // Sao chép sinh viên vào danh sách mới
        for (int i = 0; i < students.size(); i++) {
            sortedList.append(students.get(i));
        }
        int desc = order ? 1 : -1;
        // Sắp xếp theo tên và họ
        StudentComparator nameComparator = (left, right) -> {
            int comparisonResult = left.compareTo(right);
            return order ? comparisonResult : -comparisonResult; // Nếu order là true thì sắp xếp tăng dần, ngược lại giảm dần
        };
        sortedList = bubbleSort(sortedList, nameComparator);


        return sortedList;
    }

    public MyList bubbleSort(MyList list, StudentComparator comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Student left = (Student) list.get(j);
                Student right = (Student) list.get(j + 1);

                // So sánh bằng comparator
                if (comparator.compare(left, right) > 0) {
                    // Swap đúng cách: dùng biến tạm
                    list.set(left, j + 1); // Đặt left vào j+1
                    list.set(right, j);    // Đặt right vào j
                }
            }
        }
        return list;
    }


    /**
     * Lấy ra danh sách các sinh viên được sắp xếp theo average.
     * Chú ý, không thay đổi thứ tự sinh viên trong danh sách gốc.
     *
     * @param order
     * @return
     */
    public MyList sortByAverage(boolean order) {
        /*
         TODO

         - Thêm lớp AverageComparison sử dụng StudentComparator để có thể so sánh các sinh viên theo average.

         - Viết code sử dụng AverageComparison để sắp xếp sinh viên theo thứ tự phụ thuộc tham số order.
           Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách các sinh viên mới đã được sắp xếp.
         */
        MyList sortedList = new MyArrayList(); // Hoặc MyArrayList

        // Sao chép sinh viên vào danh sách mới
        for (int i = 0; i < students.size(); i++) {
            sortedList.append(students.get(i));
        }

        // Dùng StudentComparator để sắp xếp theo điểm trung bình
        StudentComparator averageComparator = (left, right) -> {
            int comparisonResult = Double.compare(left.getAverage(), right.getAverage());
            return order ? comparisonResult : -comparisonResult; // Nếu order là true thì sắp xếp tăng dần, ngược lại giảm dần
        };

        // Sắp xếp theo điểm trung bình
        sortedList = bubbleSort(sortedList, averageComparator);

        return sortedList;
    }
}
