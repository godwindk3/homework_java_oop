package hus.oop.lab11.decorator_pattern.icecream_decorator;

public class NutsToppingDecorator extends ToppingDecorator {

    private IceCream iceCream;

    public NutsToppingDecorator(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + addTopping();
    }

    @Override
    public String addTopping() {
        return " Nuts";
    }
}
