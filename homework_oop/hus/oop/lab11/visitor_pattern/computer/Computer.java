package hus.oop.lab11.visitor_pattern.computer;

public class Computer implements ComputerPart {

    ComputerPart[] Parts;

    public Computer(ComputerPart[] parts) {
        Parts = parts;
    }

    @Override
    public void accept(ComputerPartVisitor v) {
        v.visit(this);
    }

    public void print() {
        for (ComputerPart part : Parts
        ) {
            part.print();
        }
    }
}
