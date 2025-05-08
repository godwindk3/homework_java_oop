package hus.oop.lab11.iterator_pattern.iterator_pattern_example;

public class NameRepository implements Container {
    public String[] names = {"An", "Binh", "Chi", "Dung"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
