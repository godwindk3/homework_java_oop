package hus.oop.lab11.visitor_pattern.shape;

public class Rectangle implements Shape {
    public Dot topLeft;
    public Dot bottomRight;

    public Rectangle() {
        this.topLeft = new Dot();
        this.bottomRight = new Dot(-1, -1);
    }

    @Override
    public void move(double x, double y) {
        this.topLeft.setX(topLeft.getX() + x);
        this.topLeft.setY(topLeft.getY() + y);
        this.bottomRight.setX(bottomRight.getX() + x);
        this.bottomRight.setY(bottomRight.getY() + y);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle{" +
                "topLeft=" + topLeft.toString() +
                ", bottomRight=" + bottomRight.toString() +
                '}');
    }

    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topLeft=" + topLeft.toString() +
                ", bottomRight=" + bottomRight.toString() +
                '}';
    }
}
