package hus.oop.midterm_2023_good_code.students;

public class AverageComparison {
    private Student student;

    // Constructor nhận một đối tượng Student
    public AverageComparison(Student student) {
        this.student = student;
    }

    public int compareTo(AverageComparison o, StudentComparator comparator) {
        // Dùng StudentComparator để so sánh điểm trung bình của sinh viên
        return comparator.compare(this.student, o.student);
    }

    @Override
    public String toString() {
        return student.toString();
    }
}