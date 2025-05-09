package hus.oop.lab11.visitor_pattern.computer;

public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor v) {
        v.visit(this);
    }

    public void print() {
        System.out.println("Mouse");
    }
}
