package hus.oop.lab11.factory_method.dialog;

public class WebDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
