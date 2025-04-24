package hus.oop.lab10.singleton.demonstrate_pseudocode;

public class Application {
    public static void main(String[] args) {

        Database database = Database.getInstance();
        database.query("SELECT * FROM students");

        Database database1 = Database.getInstance();
        database1.query("SELECT * FROM staffs");

    }
}
