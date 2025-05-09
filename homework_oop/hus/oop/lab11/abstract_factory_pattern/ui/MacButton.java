package hus.oop.lab11.abstract_factory_pattern.ui;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering Mac Button");
    }
}
