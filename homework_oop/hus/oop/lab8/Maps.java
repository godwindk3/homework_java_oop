package hus.oop.lab8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Maps {
    public static int count(Map<Integer, Integer> map) {
        return map.size();
    }

    public static void empty(Map<Integer, Integer> map) {
        map.clear();
    }

    public static boolean contains(Map<Integer, Integer> map, int key) {
        return map.containsKey(key);
    }

    public static boolean containsKeyValue(Map<Integer, Integer> map,
                                           int key,
                                           int value) {
        return map.containsKey(key) && map.containsValue(value);
    }

    public static Set<Integer> keySet(Map<Integer, Integer> map) {
        return map.keySet();
    }

    public static Collection<Integer> values(Map<Integer, Integer> map) {
        return map.values();
    }

    public static String getColor(int value) {
        Map<Integer, String> colorMap = new HashMap<>();
        colorMap.put(0, "black");
        colorMap.put(1, "white");
        colorMap.put(2, "red");

        return colorMap.getOrDefault(value, "");
    }

    public static void main(String[] args) {
        // Create a HashMap for testing
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(1, 0);  // key=1, value=0
        testMap.put(2, 1);  // key=2, value=1
        testMap.put(3, 2);  // key=3, value=2

        // Test each method
        System.out.println("1. Number of elements in the map: " + count(testMap));
        System.out.println("2. Does the map contain key 2? " + contains(testMap, 2));
        System.out.println("3. Does the map contain key=2 and value=1? " + containsKeyValue(testMap, 2, 1));
        System.out.println("4. Set of keys: " + keySet(testMap));
        System.out.println("5. Collection of values: " + values(testMap));
        System.out.println("6. Color for value 0: " + getColor(0));
        System.out.println("7. Color for value 1: " + getColor(1));
        System.out.println("8. Color for value 3: " + getColor(3));

        // Test the empty method
        empty(testMap);
        System.out.println("9. Number of elements after clearing the map: " + count(testMap));

    }
}
