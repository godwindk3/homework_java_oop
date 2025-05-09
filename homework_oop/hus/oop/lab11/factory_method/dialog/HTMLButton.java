package hus.oop.lab11.factory_method.dialog;

public class HTMLButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>HTML Button </button>");
    }

    @Override
    public void onClick() {
        System.out.println("HTML button is clicked via browser!");
    }

}
