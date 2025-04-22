package hus.oop.train_lab9.library;

public class Dvd extends Item {
    int duration;

    public Dvd(String title, int year, int duration) {
        super(title, year);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "Dvd[" + "duration=" + this.duration
                + ", title=" + this.title + "\""
                + ", year=" + this.year + "]";

    }
}
