package hus.oop.lab7.ex_1_1;

public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double size) {
        super(size, size);
    }

    public Square(String color, boolean filled, double size) {
        super(color, filled, size, size);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth(double side) {
        this.setSide(side);
    }

    @Override
    public void setLength(double side) {
        this.setSide(side);
    }

    @Override
    public String toString() {
        return "Square{" + super.toString() + "}";
    }
}
