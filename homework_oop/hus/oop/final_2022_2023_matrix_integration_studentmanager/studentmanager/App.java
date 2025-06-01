package hus.oop.final_2022_2023_matrix_integration_studentmanager.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                String id = dataList.get(0);
                String lastname = dataList.get(1);
                String firstname = dataList.get(2);
                int yearOfBirth = Integer.parseInt(dataList.get(3));
                double mathsGrade = Double.parseDouble(dataList.get(4));
                double physicsGrade = Double.parseDouble(dataList.get(5));
                double chemistryGrade = Double.parseDouble(dataList.get(6));
                Student student = new Student.StudentBuilder(id)
                        .withLastname(lastname)
                        .withFirstname(firstname)
                        .withYearOfBirth(yearOfBirth)
                        .withMathsGrade(mathsGrade)
                        .withPhysicsGrade(physicsGrade)
                        .withChemistryGrade(chemistryGrade)
                        .build();
                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        System.out.println("testOriginalData()");
        testOriginalData();
        System.out.println();

        System.out.println("testSortYearOfBirthIncreasing()");
        testSortYearOfBirthIncreasing();
        System.out.println();

        System.out.println("testSortYearOfBirthDecreasing()");
        testSortYearOfBirthDecreasing();
        System.out.println();

        System.out.println("testSortMathsGradeIncreasing()");
        testSortMathsGradeIncreasing();
        System.out.println();

        System.out.println("testSortMathsGradeDecreasing()");
        testSortMathsGradeDecreasing();
        System.out.println();

        System.out.println("testSortPhysicsGradeIncreasing()");
        testSortPhysicsGradeIncreasing();
        System.out.println();

        System.out.println("testSortPhysicsGradeDecreasing()");
        testSortPhysicsGradeDecreasing();
        System.out.println();

        System.out.println("testSortChemistryGradeIncreasing()");
        testSortChemistryGradeIncreasing();
        System.out.println();

        System.out.println("testSortChemistryGradeDecreasing()");
        testSortChemistryGradeDecreasing();
        System.out.println();

        System.out.println("testFilterStudentsHighestMathsGrade()");
        testFilterStudentsHighestMathsGrade();
        System.out.println();

        System.out.println("testFilterStudentsLowestMathsGrade()");
        testFilterStudentsLowestMathsGrade();
        System.out.println();

        System.out.println("testFilterStudentsHighestPhysicsGrade()");
        testFilterStudentsHighestPhysicsGrade();
        System.out.println();

        System.out.println("testFilterStudentsLowestPhysicsGrade()");
        testFilterStudentsLowestPhysicsGrade();
        System.out.println();

        System.out.println("testFilterStudentsHighestChemistryGrade()");
        testFilterStudentsHighestChemistryGrade();
        System.out.println();

        System.out.println("testFilterStudentsLowestChemistryGrade()");
        testFilterStudentsLowestChemistryGrade();
        System.out.println();

        System.out.println("testFilterStudentsHighestAverageGrade()");
        testFilterStudentsHighestAverageGrade();
        System.out.println();

        System.out.println("testFilterStudentsLowestAverageGrade()");
        testFilterStudentsLowestAverageGrade();
    }

    public static void init() {
        String filePath = "C:\\Users\\ASUS\\OneDrive\\Máy tính\\Java-OOP\\homework_oop\\hus\\oop\\final_2022_2023_matrix_integration_studentmanager\\data\\students.csv";
        StudentManager.getInstance().getStudentList().clear();
        readListData(filePath);
    }

    public static void testOriginalData() {
        init();
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortYearOfBirthDecreasing() {
        init();
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeIncreasing() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeDecreasing() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeIncreasing() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeDecreasing() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        init();
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        List<Student> nLowestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestMathsGradeStudents.add(students.get(i));
        }

        String codeString = StudentManager.getInstance().idOfStudentsToString(nLowestMathsGradeStudents);
        System.out.print(codeString);
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        List<Student> nHighestPhysicsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestPhysicsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestPhysicsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        List<Student> nLowestPhysicsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestPhysicsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nLowestPhysicsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        List<Student> nHighestChemistryGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestChemistryGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestChemistryGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        List<Student> nLowestChemistryGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestChemistryGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nLowestChemistryGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        List<Student> nHighestAverageGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestAverageGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestAverageGradeStudents);
        System.out.print(studentIdsString);

    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        init();
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        List<Student> nLowestAverageGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestAverageGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nLowestAverageGradeStudents);
        System.out.print(studentIdsString);
    }
}
