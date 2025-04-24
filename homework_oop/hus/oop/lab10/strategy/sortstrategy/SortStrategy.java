package hus.oop.lab10.strategy.sortstrategy;

public class SortStrategy {
    private static SortStrategy instance;
    private ISort sortee;

    private SortStrategy() {
    }

    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public void setSortee(ISort sortee) {
        this.sortee = sortee;
    }

    public void sort(int[] array) {
        sortee.sort(array);
    }
}
