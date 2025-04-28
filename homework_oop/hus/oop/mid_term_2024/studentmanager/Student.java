//package hus.oop.mid_term_2024.studentmanager;
//
//public class Student implements MyStudentComparable {
//    private String id;
//    private String lastname;
//    private String firstname;
//    private int yearOfBirth;
//    private double mathsGrade;
//    private double physicsGrade;
//    private double chemistryGrade;
//
//    private Student() {}
//
//    public static class StudentBuilder {
//        private String id;
//        private String lastname;
//        private String firstname;
//        private int yearOfBirth;
//        private double mathsGrade;
//        private double physicsGrade;
//        private double chemistryGrade;
//
//        public StudentBuilder(String id) {
//            this.id = id;
//        }
//
//        public StudentBuilder withLastname(String lastname) {
//            /* TODO */
//            return null;
//        }
//
//        public StudentBuilder withFirstname(String firstname) {
//            /* TODO */
//            return null;
//        }
//
//        public StudentBuilder withYearOfBirth(int yearOfBirth) {
//            /* TODO */
//            return null;
//        }
//
//        public StudentBuilder withMathsGrade(double mathsGrade) {
//            /* TODO */
//            return null;
//        }
//
//        public StudentBuilder withPhysicsGrade(double physicsGrade) {
//            /* TODO */
//            return null;
//        }
//
//        public StudentBuilder withChemistryGrade(double chemistryGrade) {
//            /* TODO */
//            return null;
//        }
//
//        public Student build() {
//            Student student = new Student();
//            student.id = this.id;
//            student.lastname = this.lastname;
//            student.firstname = this.firstname;
//            student.yearOfBirth = this.yearOfBirth;
//            student.mathsGrade = this.mathsGrade;
//            student.physicsGrade = this.physicsGrade;
//            student.chemistryGrade = this.chemistryGrade;
//            return student;
//        }
//    }
//
//    public String getId() {
//        /* TODO */
//        return "";
//    }
//
//    public String getLastname() {
//        /* TODO */
//        return "";
//    }
//
//    public String getFirstname() {
//        /* TODO */
//        return "";
//    }
//
//    public int getYearOfBirth() {
//        /* TODO */
//        return 0;
//    }
//
//    public double getMathsGrade() {
//        /* TODO */
//        return 0;
//    }
//
//    public double getPhysicsGrade() {
//        /* TODO */
//        return 0;
//    }
//
//    public double getChemistryGrade() {
//        /* TODO */
//        return 0;
//    }
//
//    public double getAverageGrade() {
//        /* TODO */
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", firstname='" + firstname + '\'' +
//                ", yearOfBirth=" + yearOfBirth +
//                ", mathsGrade=" + mathsGrade +
//                ", physicsGrade=" + physicsGrade +
//                ", chemistryGrade=" + chemistryGrade +
//                '}';
//    }
//
//    /**
//     * Phương thức đưa ra tiêu chí so sánh 2 đối tượng kiểu Student sao cho
//     * thứ tự tăng dần theo tên và sau đó đến họ.
//     * @param another
//     * @return
//     */
//    @Override
//    public int compareTo(Student another) {
//        /* TODO */
//        return 0;
//    }
//}
package hus.oop.mid_term_2024.studentmanager;

public class Student implements MyStudentComparable {
    private String id;
    private String lastname;
    private String firstname;
    private int yearOfBirth;
    private double mathsGrade;
    private double physicsGrade;
    private double chemistryGrade;

    private Student() {
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getMathsGrade() {
        return mathsGrade;
    }

    public double getPhysicsGrade() {
        return physicsGrade;
    }

    public double getChemistryGrade() {
        return chemistryGrade;
    }

    public double getAverageGrade() {
        return (mathsGrade + physicsGrade + chemistryGrade) / 3.0;
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s %s', yob=%d, avg=%.2f, m=%.2f, p=%.2f, c=%.2f}",
                id, firstname, lastname, yearOfBirth, getAverageGrade(), mathsGrade, physicsGrade, chemistryGrade);
    }

    @Override
    public int compareTo(Student another) {
        int cmp = this.firstname.compareToIgnoreCase(another.firstname);
        if (cmp != 0) return cmp;
        return this.lastname.compareToIgnoreCase(another.lastname);
    }

    public static class StudentBuilder {
        private String id;
        private String lastname;
        private String firstname;
        private int yearOfBirth;
        private double mathsGrade;
        private double physicsGrade;
        private double chemistryGrade;

        public StudentBuilder(String id) {
            this.id = id;
        }

        public StudentBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder withYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public StudentBuilder withMathsGrade(double mathsGrade) {
            this.mathsGrade = mathsGrade;
            return this;
        }

        public StudentBuilder withPhysicsGrade(double physicsGrade) {
            this.physicsGrade = physicsGrade;
            return this;
        }

        public StudentBuilder withChemistryGrade(double chemistryGrade) {
            this.chemistryGrade = chemistryGrade;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.lastname = this.lastname;
            student.firstname = this.firstname;
            student.yearOfBirth = this.yearOfBirth;
            student.mathsGrade = this.mathsGrade;
            student.physicsGrade = this.physicsGrade;
            student.chemistryGrade = this.chemistryGrade;
            return student;
        }
    }
}