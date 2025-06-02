package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.mystudentmanager;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        /* TODO */
        this.studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        /* TODO */
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     *
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.insertAtEnd(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     *
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.insertAtPosition(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     *
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     *
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        MyIterator it = studentList.iterator();
        int idx = 0;
        while (it.hasNext()) {
            Student s = (Student) it.next();
            if (s.getId().equals(student.getId())) {
                studentList.remove(idx);
                break;
            }
            idx++;
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     *
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        if (index < 0 || index >= studentList.size()) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        MyIterator it = studentList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Student s = (Student) it.next();
            if (i == index) {
                return s;
            }
            i++;
        }
        return null;
    }

    /**
     * Lọc ra những sinh viên có điểm trung bình trên 15 điểm.
     *
     * @return
     */
    public MyList filterStudentsByAverageGrade() {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            if (s.getAverageGrade() > 15.0) {
                result.insertAtEnd(s);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sinh viên có điểm toán trên 5 điểm.
     *
     * @return
     */
    public MyList filterStudentsByMathGrade() {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            if (s.getMathsGrade() > 5.0) {
                result.insertAtEnd(s);
            }
        }
        return result;
    }
}
