package hus.oop.lab11.decorator_pattern.shape_decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Normal Circle: ");
        circle.draw();

        System.out.println("\nRed Circle: ");
        redCircle.draw();

        System.out.println("\nRed Rectangle: ");
        redRectangle.draw();

    }
}
