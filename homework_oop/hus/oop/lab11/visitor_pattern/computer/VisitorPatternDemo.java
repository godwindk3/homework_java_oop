package hus.oop.lab11.visitor_pattern.computer;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart monitor = new Monitor();
        ComputerPart mouse = new Mouse();
        ComputerPart keyboard = new Keyboard();

        ComputerPart[] computerParts = {monitor, mouse, keyboard};

        ComputerPart computer = new Computer(computerParts);

        ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();

        monitor.accept(visitor);

        computer.accept(visitor);
    }
}
