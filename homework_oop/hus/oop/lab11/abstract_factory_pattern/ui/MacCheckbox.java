package hus.oop.lab11.abstract_factory_pattern.ui;

public class MacCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Rendering Mac Checkbox");
    }
}
