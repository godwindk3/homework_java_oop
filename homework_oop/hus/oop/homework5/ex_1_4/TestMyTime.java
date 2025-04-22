package hus.oop.homework5.ex_1_4;

public class TestMyTime {
    public static void main(String[] args) {
        MyTime t1 = new MyTime();
        System.out.println("Default time: " + t1); // Expected: 00:00:00

        // Test parameterized constructor
        MyTime t2 = new MyTime(23, 59, 59);
        System.out.println("t2 initial: " + t2); // Expected: 23:59:59

        // Test nextSecond (overflow to next minute and hour)
        t2.nextSecond();
        System.out.println("t2 after nextSecond: " + t2); // Expected: 00:00:00

        // Test nextMinute and nextHour
        MyTime t3 = new MyTime(14, 58, 59);
        System.out.println("t3 initial: " + t3); // Expected: 14:58:59
        t3.nextMinute();
        System.out.println("t3 after nextMinute: " + t3); // Expected: 14:59:59
        t3.nextHour();
        System.out.println("t3 after nextHour: " + t3); // Expected: 15:59:59

        // Test previousSecond (underflow to previous minute and hour)
        MyTime t4 = new MyTime(0, 0, 0);
        System.out.println("t4 initial: " + t4); // Expected: 00:00:00
        t4.previousSecond();
        System.out.println("t4 after previousSecond: " + t4); // Expected: 23:59:59

        // Test previousMinute and previousHour
        MyTime t5 = new MyTime(1, 0, 0);
        System.out.println("t5 initial: " + t5); // Expected: 01:00:00
        t5.previousMinute();
        System.out.println("t5 after previousMinute: " + t5); // Expected: 00:59:00
        t5.previousHour();
        System.out.println("t5 after previousHour: " + t5); // Expected: 23:59:00

        // Test setTime
        MyTime t6 = new MyTime();
        t6.setTime(9, 5, 3);
        System.out.println("t6 after setTime: " + t6); // Expected: 09:05:03
    }
}
