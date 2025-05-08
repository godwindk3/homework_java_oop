package hus.oop.lab11.observer_pattern.observer_demo;

public class HexaObserver extends Observer {


    public HexaObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hexa: " + Integer.toHexString(subject.getState()));
    }
}
