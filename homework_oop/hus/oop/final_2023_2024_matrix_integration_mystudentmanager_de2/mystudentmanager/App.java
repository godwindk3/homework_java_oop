package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.mystudentmanager;

import java.io.*;
import java.util.ArrayList;
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

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.
                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */
                String id = dataList.get(0).trim();
                String lastname = dataList.get(1).trim();
                String firstname = dataList.get(2).trim();
                int yearOfBirth = Integer.parseInt(dataList.get(3).trim());
                double mathsGrade = Double.parseDouble(dataList.get(4).trim());
                double physicsGrade = Double.parseDouble(dataList.get(5).trim());
                double chemistryGrade = Double.parseDouble(dataList.get(6).trim());

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

    public static void main(String[] args) throws FileNotFoundException {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
        PrintStream out = new PrintStream("BuiNguyenPhong_21002165_StudentManager.txt");
        System.setOut(out);

        init();
        testOriginalData();
        testFilterStudentsByAverageGrade();
        testFilterStudentsByMathGrade();

        out.close();
    }

    public static void init() {
        String filePath = "C:\\Users\\ASUS\\OneDrive\\Máy tính\\Java-OOP\\homework_oop\\hus\\oop\\final_2023_2024_matrix_integration_mystudentmanager_de2\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        /* TODO */
        System.out.println("===== ORIGINAL STUDENT LIST =====");
        MyList list = StudentManager.getInstance().getStudentList();
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.printf("%s, %s %s, %d, Toán: %.2f, Lý: %.2f, Hóa: %.2f, TB: %.2f%n",
                    s.getId(),
                    s.getLastname(),
                    s.getFirstname(),
                    s.getYearOfBirth(),
                    s.getMathsGrade(),
                    s.getPhysicsGrade(),
                    s.getChemistryGrade(),
                    s.getAverageGrade());
        }
        System.out.println();
    }

    public static void testFilterStudentsByAverageGrade() {
        /* TODO */
        System.out.println("===== STUDENTS WITH AVERAGE > 15 =====");
        MyList filtered = StudentManager.getInstance().filterStudentsByAverageGrade();
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.printf("%s, %s %s, TB: %.2f%n",
                    s.getId(),
                    s.getLastname(),
                    s.getFirstname(),
                    s.getAverageGrade());
        }
        System.out.println();
    }

    public static void testFilterStudentsByMathGrade() {
        /* TODO */
        System.out.println("===== STUDENTS WITH MATH > 5 =====");
        MyList filtered = StudentManager.getInstance().filterStudentsByMathGrade();
        MyIterator it = filtered.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.printf("%s, %s %s, Toán: %.2f%n",
                    s.getId(),
                    s.getLastname(),
                    s.getFirstname(),
                    s.getMathsGrade());
        }
        System.out.println();
    }
}
