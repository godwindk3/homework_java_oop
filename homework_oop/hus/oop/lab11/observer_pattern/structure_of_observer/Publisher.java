package hus.oop.lab11.observer_pattern.structure_of_observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private int mainState;

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribes() {
        for (Subscriber s : subscribers) {
            s.update();
        }
    }

    public void mainBusinessLogic() {
        mainState = (int) (Math.random() * 100);
        notifySubscribes();
    }

    public int getMainState() {
        return mainState;
    }

}
