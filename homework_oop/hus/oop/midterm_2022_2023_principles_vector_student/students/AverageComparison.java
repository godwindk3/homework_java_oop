
package hus.oop.midterm_2022_2023_principles_vector_student.students;

public class AverageComparison implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.average, right.average);
    }
}

