package hus.oop.lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void insertFirst(List<Integer> list, int value) {
        list.add(0, value);
    }

    public static void insertLast(List<Integer> list, int value) {
        list.add(value);

    }

    public static void replace(List<Integer> list, int value) {
        if (list.size() >= 3) {
            list.set(2, value);
        }
    }

    public static void removeThird(List<Integer> list) {
        if (list.size() >= 3) {
            list.remove(2);
        }
    }

    public static void removeEvil(List<Integer> list) {
        list.removeIf(num -> num == 666);
    }

    public static List<Integer> generateSquare() {
        List<Integer> firstTenSquareNumbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            firstTenSquareNumbers.add(i * i);
        }

        return firstTenSquareNumbers;
    }

    public static boolean contains(List<Integer> list, int value) {
        return list.contains(value);
    }

    public static void copy(List<Integer> source, List<Integer> target) {
        while (!target.isEmpty()) {
            target.remove(0);
        }
        for (int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }

    public static void reverse(List<Integer> list) {
        Collections.reverse(list);
    }

    public static void reverseManual(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void insertBeginningEnd(LinkedList<Integer> list, int value) {
        list.add(0, value);
        list.add(value);

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 666, 4, 5, 666));

        System.out.println("Original list: " + list.toString());

        insertFirst(list, 0);
        System.out.println("After insert 0 to the first position: " + list.toString());

        insertLast(list, 6);
        System.out.println("After insert 6 to the last position" + list.toString());

        replace(list, 10);
        System.out.println("After replace 3rd element from list by 10: " + list.toString());

        removeThird(list);
        System.out.println("After remove 3rd element from list: " + list.toString());

        removeEvil(list);
        System.out.println("After remove 666 from list: " + list.toString());

        List<Integer> squareList = new ArrayList<>(generateSquare());
        System.out.println("List of first 10 square number: " + squareList.toString());


        System.out.println("Check if 666 in the list or not: " + contains(list, 666));

        copy(list, squareList);
        System.out.println("Copy square list from list: " + squareList.toString());

        reverse(list);
        System.out.println("Reverse a list by library: " + list.toString());

        reverseManual(list);
        System.out.println("Reverse a list by manual reverse: " + list.toString());

        LinkedList<Integer> linkedList = new LinkedList<>(list);

        insertBeginningEnd(linkedList, 505);
        System.out.println("Insert 505 to beginning and end of a linked list: " + linkedList.toString());

    }


}
