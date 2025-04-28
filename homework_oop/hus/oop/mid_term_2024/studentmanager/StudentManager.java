//package hus.oop.mid_term_2024.studentmanager;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class StudentManager {
//    private List<Student> studentList;
//
//    public StudentManager() {
//        this.studentList = new LinkedList<>();
//    }
//
//    /**
//     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
//     * @param index
//     * @param limit
//     * @return
//     */
//    private boolean checkBoundaries(int index, int limit) {
//        /* TODO */
//        return false;
//    }
//
//    public List<Student> getStudentList() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Thêm sinh viên vào cuối danh sách.
//     * @param student
//     */
//    public void append(Student student) {
//        /* TODO */
//    }
//
//    /**
//     * Thêm sinh viên vào danh sách ở vị trí index, chỉ thêm vào nếu index có giá trị
//     * nằm trong đoạn từ [0 - length], trong đó length là số sinh viên trong danh sách hiện tại.
//     * @param student
//     * @param index
//     */
//    public void add(Student student, int index) {
//        /* TODO */
//    }
//
//    /**
//     * Xóa sinh viên ở vị trí index, chỉ xóa được nếu index nằm trong đoạn [0 - (length - 1)],
//     * trong đó length là số sinh viên trong danh sách hiện tại.
//     * @param index
//     */
//    public void remove(int index) {
//        /* TODO */
//    }
//
//    /**
//     * Lấy ra sinh viên ở vị trí index.
//     * @param index
//     * @return
//     */
//    public Student studentAt(int index) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên và sau đó đến họ.
//     * @return
//     */
//    public List<Student> sortStudentByName() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
//     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
//     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
//     *
//     * @return
//     */
//    public List<Student> sortByGradeIncreasing() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Sắp xếp danh sách sinh viên theo thứ tự giảm dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
//     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
//     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
//     *
//     * @return
//     */
//    public List<Student> sortByGradeDecreasing() {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Lọc ra howMany sinh viên có kết quả tốt nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
//     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
//     * @param howMany
//     * @return
//     */
//    public List<Student> filterStudentsHighestGrade(int howMany) {
//        /* TODO */
//        return null;
//    }
//
//    /**
//     * Lọc ra howMany sinh viên có kết quả thấp nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
//     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
//     * @param howMany
//     * @return
//     */
//    public List<Student> filterStudentsLowestGrade(int howMany) {
//        /* TODO */
//        return null;
//    }
//
//    public static String idOfStudentsToString(List<Student> studentList) {
//        StringBuilder idOfStudents = new StringBuilder();
//        idOfStudents.append("[");
//        for (Student student : studentList) {
//            idOfStudents.append(student.getId()).append(" ");
//        }
//        return idOfStudents.toString().trim() + "]";
//    }
//
//    public static void print(List<Student> studentList) {
//        StringBuilder studentsString = new StringBuilder();
//        studentsString.append("[\n");
//        for (Student student : studentList) {
//            studentsString.append(student.toString()).append("\n");
//        }
//        System.out.print(studentsString.toString().trim() + "\n]");
//    }
//}
package hus.oop.mid_term_2024.studentmanager;
import java.util.*;
public class StudentManager {
    private List<Student> studentList;
    public StudentManager() { this.studentList = new LinkedList<>(); }
    private boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }
    public List<Student> getStudentList() { return studentList; }
    public void append(Student student) { studentList.add(student); }
    public void add(Student student, int index) {
        if (checkBoundaries(index, studentList.size())) studentList.add(index, student);
    }
    public void remove(int index) {
        if (checkBoundaries(index, studentList.size() - 1)) studentList.remove(index);
    }
    public Student studentAt(int index) {
        if (checkBoundaries(index, studentList.size() - 1)) return studentList.get(index);
        return null;
    }
    public List<Student> sortStudentByName() {
        List<Student> sorted = new ArrayList<>(studentList);
        Collections.sort(sorted, Student::compareTo);
        return sorted;
    }
    public List<Student> sortByGradeIncreasing() {
        List<Student> sorted = new ArrayList<>(studentList);
        sorted.sort((a,b) -> {
            int cmp = Double.compare(a.getAverageGrade(), b.getAverageGrade());
            if (cmp!=0) return cmp;
            return Double.compare(a.getMathsGrade(), b.getMathsGrade());
        });
        return sorted;
    }
    public List<Student> sortByGradeDecreasing() {
        List<Student> sorted = sortByGradeIncreasing();
        Collections.reverse(sorted);
        return sorted;
    }
    public List<Student> filterStudentsHighestGrade(int howMany) {
        List<Student> sorted = sortByGradeDecreasing();
        return sorted.subList(0, Math.min(howMany, sorted.size()));
    }
    public List<Student> filterStudentsLowestGrade(int howMany) {
        List<Student> sorted = sortByGradeIncreasing();
        return sorted.subList(0, Math.min(howMany, sorted.size()));
    }
    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder sb = new StringBuilder("[");
        for (Student s: studentList) sb.append(s.getId()).append(" ");
        return sb.toString().trim() + "]";
    }
    public static void print(List<Student> studentList) {
        System.out.println("[");
        for (Student s: studentList) System.out.println("  "+s);
        System.out.println("]");
    }
}
