//package hus.oop.midterm_2023.students;
//
//import java.util.Objects;
//
//public class Student {
//    String name;
//    String lastname;
//    double average;
//
//    public Student(String name, String lastname, double average) {
//        this.name = name;
//        this.lastname = lastname;
//        this.average = average;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public double getAverage() {
//        return average;
//    }
//
//    public void setAverage(double average) {
//        this.average = average;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        Student student = (Student) o;
//        return Double.compare(student.average, average) == 0
//                && Objects.equals(name, student.name)
//                && Objects.equals(lastname, student.lastname);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, lastname, average);
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", average=" + average +
//                '}';
//    }
//}
package hus.oop.midterm_2022_2023_principles_vector_student.students;

import java.util.Objects;

public class Student implements StudentComparable {
    String name;
    String lastname;
    double average;

    public Student(String name, String lastname, double average) {
        this.name = name;
        this.lastname = lastname;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Double.compare(student.average, average) == 0
                && Objects.equals(name, student.name)
                && Objects.equals(lastname, student.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, average);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", average=" + average +
                '}';
    }

    @Override
    public int compareTo(Student another) {
        int nameComparison = this.name.compareTo(another.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return this.lastname.compareTo(another.lastname);
    }
}