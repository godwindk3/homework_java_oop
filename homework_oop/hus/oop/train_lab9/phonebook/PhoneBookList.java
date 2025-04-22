package hus.oop.train_lab9.phonebook;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PhoneBookList implements PhoneBook{

    ArrayList<Student> phoneBook;

    public PhoneBookList() {
        phoneBook = new ArrayList<>();
    }

    @Override
    public void addPerson(Student p) {
        phoneBook.add(p);
    }

    @Override
    public Student searchByName(String name) {
        for (Student student: phoneBook ) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Student searchByLastname(String lastname) {
        for (Student student: phoneBook ) {
            if (student.getLastname().equals(lastname)) {
                return student;
            }
        }
        return null;
    }

    public Student searchByNumber(String phone) {
        for (Student student: phoneBook ) {
            if (student.getPhone().equals(phone)) {
                return student;
            }
        }
        return null;
    }

    public void deleteByNumber(String phone) {
        Student student = searchByNumber(phone);
        phoneBook.remove(student);
    }
}
