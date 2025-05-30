package hus.oop.lab11.visitor_pattern.computer;

public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
