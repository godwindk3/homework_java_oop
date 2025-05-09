package hus.oop.lab11.abstract_factory_pattern.ui;

public class WinCheckBox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Rendering Windows Checkbox");
    }
}
