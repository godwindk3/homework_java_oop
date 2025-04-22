package hus.oop.train_lab9.phonebook;

import java.util.HashMap;

public class PhoneBookMap implements PhoneBook{
    HashMap<String, Student> phoneBook;

    public PhoneBookMap() {
        phoneBook = new HashMap<>();
    }

    public void addPerson(Student s) {
        phoneBook.put(s.getPhone(), s);
    }

    public Student searchByName(String name) {
        for (Student student: phoneBook.values()) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Student searchByLastname(String lastname) {
        for (Student student: phoneBook.values()) {
            if (student.getLastname().equals(lastname)) {
                return student;
            }
        }
        return null;
    }

    public Student searchByNumber(String phone) {
        for (Student student: phoneBook.values()) {
            if (student.getPhone().equals(phone)) {
                return student;
            }
        }

        return null;
    }

    public void deleteByNumber(String phone) {
        phoneBook.remove(phone);
    }
}
