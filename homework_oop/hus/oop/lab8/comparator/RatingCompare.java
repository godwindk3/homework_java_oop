package hus.oop.lab8.comparator;

import java.util.Comparator;

class RatingCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie left, Movie right) {
        return Double.compare(left.getRating(), right.getRating());
    }
}
