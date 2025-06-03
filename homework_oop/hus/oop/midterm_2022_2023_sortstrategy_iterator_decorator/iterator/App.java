package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.iterator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {

    public static void main(String args[]) {
        StringBuilder output = new StringBuilder();

        MyArray myArray = new MyArray();
        myArray.addItem("ArrayItem1");
        myArray.addItem("ArrayItem2");
        myArray.addItem("ArrayItem3");
        myArray.addItem("ArrayItem4");
        myArray.addItem("ArrayItem5");
        myArray.addItem("ArrayItem6");

        MyList myList = new MyList();
        myList.addItem("ListItem1");
        myList.addItem("ListItem2");
        myList.addItem("ListItem3");
        myList.addItem("ListItem4");
        myList.addItem("ListItem5");
        myList.addItem("ListItem6");

        // with no iterators
        output.append("\nITEMS with loops\n----\nARRAY\n");
        ArrayList<String> myArrayItems = myList.getMenuItems();
        for (int i = 0; i < myArrayItems.size(); i++) {
            String menuItem = myArrayItems.get(i);
            output.append(menuItem).append("\n");
        }

        output.append("\nLIST\n");
        String[] myListItems = myArray.getMenuItems();
        for (int i = 0; i < myListItems.length; i++) {
            String menuItem = myListItems[i];
            output.append(menuItem).append("\n");
        }

        // with iterators
        Iterator myListIterator = myList.createIterator();
        Iterator myArrayIterator = myArray.createIterator();

        output.append("\nITEMS (with iterators)\n----\nARRAY\n");
        appendItems(output, myArrayIterator);
        output.append("\nLIST\n");
        appendItems(output, myListIterator);

        // In kết quả ra console
        System.out.println(output.toString());

        // Lưu kết quả vào file
        saveToFile(output.toString(), "MyIterator21002165.txt");
    }

    private static void appendItems(StringBuilder output, Iterator iterator) {
        while (iterator.hasNext()) {
            String item = (String) iterator.next();
            output.append(item).append("\n");
        }
    }

    private static void saveToFile(String content, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
