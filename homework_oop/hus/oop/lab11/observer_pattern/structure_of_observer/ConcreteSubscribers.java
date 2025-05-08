package hus.oop.lab11.observer_pattern.structure_of_observer;

public class ConcreteSubscribers implements Subscriber {
    private Publisher publisher;
    private int context;


    public ConcreteSubscribers(Publisher publisher) {
        this.publisher = publisher;
        publisher.subscribe(this);
    }

    @Override
    public void update() {
        this.context = publisher.getMainState();
        System.out.println("Subscribe updated with context: " + context);
    }
}
