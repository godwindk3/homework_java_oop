package hus.oop.lab8.comparator;

import java.util.Comparator;

class NameCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie left, Movie right) {
        return left.getName().compareTo(right.getName());
    }
}
