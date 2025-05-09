package hus.oop.lab11.decorator_pattern.icecream_decorator;

public abstract class ToppingDecorator implements IceCream {

    public IceCream iceCream;

    public ToppingDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription();
    }

    abstract public String addTopping();

}
