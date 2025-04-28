
package hus.oop.midterm_2023.students;

public class AverageComparison implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.average, right.average);
    }
}

