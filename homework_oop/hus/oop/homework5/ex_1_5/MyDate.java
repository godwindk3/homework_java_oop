package hus.oop.homework5.ex_1_5;

public class MyDate {
    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] DAYSINMONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date: " + year + "-" + month + "-" + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= daysInMonth[month - 1];
    }

    public int getDayOfWeek(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            if (month < 3) {
                month += 12;
                year -= 1;
            }

            int K = year % 100;
            int J = year / 100;

            int h = (day + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) - 2 * J);
            h = (h % 7 + 7) % 7;
            h = (h + 6) % 7;

            return h;
        } else return -1;
    }

    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date: " + year + "-" + month + "-" + day);
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (isValidDate(year, this.getMonth(), this.getDay())) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Not a valid year");
        }

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValidDate(this.getYear(), month, this.getDay())) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Not a valid month!");
        }

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isValidDate(this.getYear(), this.getMonth(), day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Not a valid day!");
        }

    }

    public String toString() {
        int dayOfWeek = this.getDayOfWeek(year, month, day);
        String str = DAYS[dayOfWeek] + " " + day + " " + MONTHS[month - 1] + " " + year;

        return str;
    }

    public MyDate nextYear() {
        if (this.getYear() == 9999) {
            return this;
        }
        int newYear = this.getYear() + 1;
        if (!isValidDate(newYear, this.getMonth(), this.getDay())) {
            this.setDay(DAYSINMONTHS[this.getMonth() - 1]);
        }
        this.setYear(newYear);
        return this;

    }

    public MyDate nextMonth() {
//        if (this.getMonth() == 12) {
//            this.nextYear();
//            this.setMonth(1);
//        } else {
//            this.setMonth(this.getMonth() + 1);
//        }
//        int maxDays = DAYSINMONTHS[this.getMonth() - 1];
//        if (this.getMonth() == 2 && isLeapYear(this.getYear())) {
//            maxDays = 29;
//        }
//        if (this.getDay() > maxDays) {
//            this.setDay(maxDays);
//        }
//        return this;
        int newMonth = (this.getMonth() == 12) ? 1 : this.getMonth() + 1;
        int maxDays = DAYSINMONTHS[newMonth - 1];
        if (newMonth == 2 && isLeapYear(this.getYear())) {
            maxDays = 29;
        }
        if (this.getDay() > maxDays) {
            this.setDay(maxDays);
        }
        if (this.getMonth() == 12) {
            this.nextYear();
        }
        this.setMonth(newMonth);
        return this;
    }

    public MyDate nextDay() {
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.getDay() == daysInMonth[month - 1]) {
            this.nextMonth();
            this.setDay(1);
        } else {
            this.setDay(this.getDay() + 1);
        }
        return this;
    }

    public MyDate previousYear() {
        if (this.getYear() == 1) {
            return this;
        }
        int oldYear = this.getYear() - 1;
        if (!isValidDate(oldYear, this.getMonth(), this.getDay())) {
            this.setDay(DAYSINMONTHS[this.getMonth() - 1]);
        }
        this.setYear(oldYear);
        return this;
    }

    public MyDate previousMonth() {
//        if (this.getMonth() == 1) {
//            this.previousYear();
//            this.setMonth(12);
//        } else {
//            this.setMonth(this.getMonth() - 1);
//        }
//        int maxDays = DAYSINMONTHS[this.getMonth() - 1];
//        if (this.getMonth() == 2 && isLeapYear(this.getYear())) {
//            maxDays = 29;
//        }
//        if (this.getDay() > maxDays) {
//            this.setDay(maxDays);
//        }
//        return this;
        int newMonth = (this.getMonth() == 1) ? 12 : this.getMonth() - 1;
        int maxDays = DAYSINMONTHS[newMonth - 1];
        if (newMonth == 2 && isLeapYear(this.getYear())) {
            maxDays = 29;
        }
        if (this.getDay() > maxDays) {
            this.setDay(maxDays);
        }
        if (this.getMonth() == 1) {
            this.previousYear();
        }
        this.setMonth(newMonth);
        return this;
    }

    public MyDate previousDay() {
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.getDay() == 1) {
            this.previousMonth();
            this.setDay(daysInMonth[this.getMonth() - 1]);
        } else {
            this.setDay(this.getDay() - 1);
        }
        return this;

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyDate other = (MyDate) obj;
        return this.year == other.year &&
                this.month == other.month &&
                this.day == other.day;
    }

}
