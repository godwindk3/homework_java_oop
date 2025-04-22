package hus.oop.homework5.ex_1_4;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public MyTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59");
        }
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59");
        }
        this.second = second;
    }

    public String toString() {
        String str = "";
        if (this.getHour() < 10) {
            str += "0" + this.getHour() + ":";
        } else {
            str += this.getHour() + ":";
        }
        if (this.getMinute() < 10) {
            str += "0" + this.getMinute() + ":";
        } else {
            str += this.getMinute() + ":";
        }
        if (this.getSecond() < 10) {
            str += "0" + this.getSecond();
        } else {
            str += this.getSecond();
        }
        return str;
    }

    public MyTime nextHour() {
        if (this.getHour() == 23) {
            this.setHour(0);
        } else {
            this.setHour(this.getHour() + 1);
        }
        return this;
    }

    public MyTime nextMinute() {
        if (this.getMinute() == 59) {
            this.nextHour();
            this.setMinute(0);
        } else {
            this.setMinute(this.getMinute() + 1);
        }
        return this;
    }

    public MyTime nextSecond() {
        if (this.getSecond() == 59) {
            this.nextMinute();
            this.setSecond(0);
        } else {
            this.setSecond(this.getSecond() + 1);
        }
        return this;
    }

    public MyTime previousHour() {
        if (this.getHour() == 0) {
            this.setHour(23);
        } else {
            this.setHour(this.getHour() - 1);
        }
        return this;
    }

    public MyTime previousMinute() {
        if (this.getMinute() == 0) {
            this.previousHour();
            this.setMinute(59);
        } else {
            this.setMinute(this.getMinute() - 1);
        }
        return this;
    }

    public MyTime previousSecond() {
        if (this.getSecond() == 0) {
            this.previousMinute();
            this.setSecond(59);
        } else {
            this.setSecond(this.getSecond() - 1);
        }
        return this;
    }

}
