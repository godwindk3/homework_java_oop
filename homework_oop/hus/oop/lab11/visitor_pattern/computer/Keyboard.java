package hus.oop.lab11.visitor_pattern.computer;

public class Keyboard implements ComputerPart {


    @Override
    public void accept(ComputerPartVisitor v) {
        v.visit(this);
    }

    public void print() {
        System.out.println("Keyboard");
    }
}
