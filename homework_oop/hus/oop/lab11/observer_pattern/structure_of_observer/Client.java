package hus.oop.lab11.observer_pattern.structure_of_observer;

public class Client {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
//        ConcreteSubscribers s = new ConcreteSubscribers(publisher);

        Subscriber s1 = new ConcreteSubscribers(publisher);
        Subscriber s2 = new ConcreteSubscribers(publisher);

        for (int i = 0; i < 3; i++) {
            publisher.mainBusinessLogic();
        }
    }
}
