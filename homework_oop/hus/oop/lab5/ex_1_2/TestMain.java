package hus.oop.lab5.ex_1_2;

public class TestMain {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St");
        System.out.println(person);

        // Test Staff
        Staff staff = new Staff("Jane Smith", "456 Oak Ave", "High School", 3000.0);
        System.out.println(staff);
        staff.setPay(3500.0);
        System.out.println("After updating pay: " + staff);

        // Test Student
        Student student = new Student("Alice Johnson", "789 Pine Rd", "Computer Science", 2023, 5000.0);
        System.out.println(student);
        student.setFee(5500.0);
        System.out.println("After updating fee: " + student);
    }
}
