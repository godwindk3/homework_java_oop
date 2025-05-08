package hus.oop.lab11.observer_pattern.observer_demo;

public abstract class Observer {

    public Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    public abstract void update();

}
