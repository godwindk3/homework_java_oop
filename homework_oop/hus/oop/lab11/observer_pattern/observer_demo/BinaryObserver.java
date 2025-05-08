package hus.oop.lab11.observer_pattern.observer_demo;

public class BinaryObserver extends Observer {


    public BinaryObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary: " + Integer.toBinaryString(subject.getState()));
    }
}
