package hus.oop.lab11.observer_pattern.observer_demo;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal: " + Integer.toOctalString(subject.getState()));
    }
}
