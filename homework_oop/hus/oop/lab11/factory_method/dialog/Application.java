package hus.oop.lab11.factory_method.dialog;

public class Application {
    private Dialog dialog;

    public static void main(String[] args) {
        Application app = new Application();
        app.main("windows");
        System.out.println();
        app.main("WEB");
    }

    public void initialize(String os) {
        if (os.equalsIgnoreCase("Windows")) {
            dialog = new WindowsDialog();
        } else if (os.equalsIgnoreCase("Web")) {
            dialog = new WebDialog();
        } else {
            throw new IllegalArgumentException("Error! Unknown OS");
        }
    }

    public void main(String os) {
        initialize(os);
        dialog.render();
    }
}
