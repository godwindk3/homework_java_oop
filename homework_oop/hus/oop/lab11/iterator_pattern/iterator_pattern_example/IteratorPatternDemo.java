package hus.oop.lab11.iterator_pattern.iterator_pattern_example;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository repo = new NameRepository();

        Iterator it = repo.getIterator();

        while (it.hasNext()) {
            String name = (String) it.next();
            System.out.println("Name: " + name);
        }
    }
}
