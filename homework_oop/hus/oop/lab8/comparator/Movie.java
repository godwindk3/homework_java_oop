package hus.oop.lab8.comparator;


class Movie implements Comparable<Movie> {
    private String name;
    private double rating;
    private int year;


    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public int compareTo(Movie m) {
        return Integer.compare(this.year, m.getYear());
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
}
