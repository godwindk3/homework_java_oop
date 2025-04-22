package hus.oop.homework3;

public class DateUtility {
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return day <= daysInMonth[month - 1];
    }

    public static int getDayOfWeek(int year, int month, int day) {
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

    public static String toString(int year, int month, int day) {
        String[] strMonths = {"Jan", "Feb,", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayOfWeek = getDayOfWeek(year, month, day);

        return strDays[dayOfWeek] + " " + day + " " + strMonths[month - 1] + " " + year;
    }

    public static void main(String[] args) {
//        System.out.println(getDayOfWeek(2025, 3, 11));
        System.out.println(toString(2025, 3, 11));
    }
}
