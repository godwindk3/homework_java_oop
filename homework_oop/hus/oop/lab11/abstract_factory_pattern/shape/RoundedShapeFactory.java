package hus.oop.lab11.abstract_factory_pattern.shape;

public class RoundedShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new RoundedSquare();
        }
        return null;
    }
}
