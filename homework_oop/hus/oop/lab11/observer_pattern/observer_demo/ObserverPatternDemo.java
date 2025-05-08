package hus.oop.lab11.observer_pattern.observer_demo;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer hexa = new HexaObserver(subject);
        Observer binary = new BinaryObserver(subject);
        Observer octal = new OctalObserver(subject);

//        subject.attach(hexa);
//        subject.attach(binary);
//        subject.attach(octal);

        subject.setState(10);
    }
}
