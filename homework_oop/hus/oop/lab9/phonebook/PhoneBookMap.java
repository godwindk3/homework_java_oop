package hus.oop.lab9.phonebook;

import java.util.HashMap;

public class PhoneBookMap implements PhoneBook {
    HashMap<String, Student> phoneBook;

    public PhoneBookMap() {
        phoneBook = new HashMap<>();
    }


    @Override
    public void addPerson(Student p) {
        if (!phoneBook.containsKey(p.getPhone())) {
            phoneBook.put(p.getPhone(), p);
        }
    }

    @Override
    public Student searchByName(String name) {
        for (Student student : phoneBook.values()) {
            if (student.getName().equals(name)) return student;
        }

        return null;
    }

    @Override
    public Student searchByLastname(String lastname) {
        for (Student student : phoneBook.values()) {
            if (student.getLastname().equals(lastname)) return student;
        }
        return null;
    }

    @Override
    public Student searchByNumber(String phone) {
        for (Student student : phoneBook.values()) {
            if (student.getPhone().equals(phone)) return student;
        }
        return null;
    }

    @Override
    public void deleteByNumber(String phone) {
        phoneBook.remove(phone);
    }
}
