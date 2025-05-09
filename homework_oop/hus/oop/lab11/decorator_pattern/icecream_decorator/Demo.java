package hus.oop.lab11.decorator_pattern.icecream_decorator;

public class Demo {
    public static void main(String[] args) {
        IceCream vanilla = new VanillaIceCream();
        IceCream vanillaNuts = new NutsToppingDecorator(vanilla);
        System.out.println(vanillaNuts.getDescription());

        IceCream chocolate = new ChocolateIceCream();
        IceCream chocolateHoney = new HoneyToppingDecorator(chocolate);
        System.out.println(chocolateHoney.getDescription());

        IceCream strawberry = new StrawberryIceCream();
        IceCream strawberryNut = new NutsToppingDecorator(strawberry);
        IceCream strawberryNutHoney = new HoneyToppingDecorator(strawberryNut);
        System.out.println(strawberryNutHoney.getDescription());

    }
}
