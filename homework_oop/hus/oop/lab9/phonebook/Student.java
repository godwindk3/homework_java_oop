package hus.oop.lab9.phonebook;

import java.util.Objects;

public class Student implements Comparable<Student> {
    String name;
    String lastname;
    String phone;
    double average;

    public Student(String name, String lastname, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
    }

    public Student(String name, String lastname, double average) {
        this.name = name;
        this.lastname = lastname;
        this.average = average;
    }

    public Student(String name, String lastname, String phone, double average) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.average = average;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, phone, average);
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student[name= " + name + '\''
                + ", lastname= " + lastname + '\''
                + ", phone= " + phone + '\''
                + ", average= " + average + '\''
                + "]";
    }

}
