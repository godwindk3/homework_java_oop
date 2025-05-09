package hus.oop.lab11.visitor_pattern.computer;

public interface ComputerPart {

    void accept(ComputerPartVisitor v);

    void print();
}
