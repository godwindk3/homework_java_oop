package hus.oop.test_exam_training_2022.iterator;

import java.util.ArrayList;

public class MyList implements MyIterable {
    private ArrayList<String> menuItems;

    public MyList() {
        menuItems = new ArrayList<String>();
    }

    public void addItem(String name) {
        menuItems.add(name);
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator() {
        return new MyListIterator(menuItems);
    }

    public String toString() {
        return "My List Structure";
    }
}