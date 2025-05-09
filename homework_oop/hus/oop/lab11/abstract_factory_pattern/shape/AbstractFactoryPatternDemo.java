package hus.oop.lab11.abstract_factory_pattern.shape;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        Shape rectangle = shapeFactory.getShape("rectangle");
        Shape square = shapeFactory.getShape("square");

        rectangle.draw();
        square.draw();

        //

        AbstractFactory roundedFactory = FactoryProducer.getFactory(true);

        Shape roundedRectangle = roundedFactory.getShape("rectangle");
        Shape roundedSquare = roundedFactory.getShape("square");

        roundedRectangle.draw();
        roundedSquare.draw();
    }
}
