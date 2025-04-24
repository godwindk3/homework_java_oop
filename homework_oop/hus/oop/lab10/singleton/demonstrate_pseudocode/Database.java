package hus.oop.lab10.singleton.demonstrate_pseudocode;

public class Database {

    private static Database instance;

    private Database() {
        System.out.println("Database connection established");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}
