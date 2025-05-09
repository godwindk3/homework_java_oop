package hus.oop.lab11.visitor_pattern.computer;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        computer.print();
    }

    @Override
    public void visit(Mouse mouse) {
        mouse.print();
    }

    @Override
    public void visit(Keyboard keyboard) {
        keyboard.print();
    }

    @Override
    public void visit(Monitor monitor) {
        monitor.print();
    }
}
