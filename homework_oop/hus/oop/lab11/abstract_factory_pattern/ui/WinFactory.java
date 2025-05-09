package hus.oop.lab11.abstract_factory_pattern.ui;

public class WinFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckBox();
    }
}
