package hus.oop.lab5.ex_1_4;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        this.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        this.setWidth(side);
    }

    @Override
    public String toString() {
        return "Square{" + super.toString() + "}";
    }
}
