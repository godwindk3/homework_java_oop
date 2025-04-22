package hus.oop.homework5.ex_1_5;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2012, 2, 28);
        System.out.println(date1);
        System.out.println(date1.nextDay());
        System.out.println(date1.nextDay());
        System.out.println(date1.nextMonth());
        System.out.println(date1.nextYear());

        MyDate date2 = new MyDate(2012, 1 , 2);
        System.out.println(date2);
        System.out.println(date2.previousDay());
        System.out.println(date2.previousDay());
        System.out.println(date2.previousMonth());
        System.out.println(date2.previousYear());

        MyDate date3 = new MyDate(2012, 2, 29);
        System.out.println(date3.previousYear());


        MyDate date = new MyDate(2011, 12, 29);


        MyDate endDate = new MyDate(2012, 3, 2);

        System.out.println("Start: " + date);

        while (!date.equals(endDate)) {
            date.nextDay();
            System.out.println(date);
        }
    }
}
