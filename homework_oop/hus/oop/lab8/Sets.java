package hus.oop.lab8;

import java.util.*;

public class Sets {
    public static Set<Integer> intersectionManual(Set<Integer> first,
                                                  Set<Integer> second) {
        Set<Integer> newSet = new HashSet<>();
        for (Integer elementFirst : first) {
            for (Integer elementSecond : second) {
                if (elementFirst == elementSecond) {
                    newSet.add(elementFirst);
                }

            }
        }
        return newSet;
    }

    public static Set<Integer> unionManual(Set<Integer> first,
                                           Set<Integer> second) {
        Set<Integer> newSet = new HashSet<>();
        for (Integer elementFirst : first) {
            newSet.add(elementFirst);
        }
        for (Integer elementSecond : second) {
            newSet.add(elementSecond);
        }
        return newSet;
    }

    public static Set<Integer> intersection(Set<Integer> first,
                                            Set<Integer> second) {

        Set<Integer> newSet = new HashSet<>(first);
        newSet.retainAll(second);
        return newSet;
    }

    public static Set<Integer> union(Set<Integer> first,
                                     Set<Integer> second) {
        Set<Integer> newSet = new HashSet<>(first);
        newSet.addAll(second);
        return newSet;
    }

    public static List<Integer> toList(Set<Integer> source) {
        return new ArrayList<>(source);
    }

    public static List<Integer> removeDuplicates(List<Integer> source) {
        Set<Integer> set = new HashSet<>(source);
        source.clear();
        source.addAll(set);
        return source;
    }

    public static List<Integer> removeDuplicatesManual(List<Integer> source) {
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer element : source) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }
        return uniqueList;

    }

    public static String firstRecurringCharacter(String s) {
        Set<String> seen = new HashSet<>();
        String[] myStringArray = s.split("");
        for (String ch : myStringArray) {
            if (!seen.add(ch)) {
                return ch;
            }
        }
        return "";

    }

    public static Set<Character> allRecurringChars(String s) {
        Set<Character> seen = new HashSet<>();
        char[] charArray = s.toCharArray();
        Set<Character> result = new HashSet<>();
        for (Character ch : charArray) {
            if (!seen.add(ch)) {
                result.add(ch);
            }
        }
        return result;
    }

    public static Integer[] toArray(Set<Integer> source) {
        Integer[] result = new Integer[source.size()];
        int i = 0;
        for (Integer element : source) {
            result[i++] = element;
        }
        return result;
    }

    public static int getFirst(TreeSet<Integer> source) {
        return source.first();
    }

    public static int getLast(TreeSet<Integer> source) {
        return source.last();
    }

    public static int getGreater(TreeSet<Integer> source, int value) {
        return source.higher(value);

    }

    public static void main(String[] args) {
        // Test sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));

        System.out.println("1. Intersection manual: " + intersectionManual(set1, set2)); // [2, 3]
        System.out.println("2. Union manual: " + unionManual(set1, set2)); // [1, 2, 3, 4]
        System.out.println("3. Intersection: " + intersection(set1, set2)); // [2, 3]
        System.out.println("4. Union: " + union(set1, set2)); // [1, 2, 3, 4]

        // Test list conversion and duplicates
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3));
        System.out.println("5. To list: " + toList(set1)); // [1, 2, 3]
        System.out.println("6. Remove duplicates: " + removeDuplicates(list)); // [1, 2, 3]
        System.out.println("7. Remove duplicates manual: " + removeDuplicatesManual(new ArrayList<>(Arrays.asList(1, 2, 2, 3)))); // [1, 2, 3]

        // Test string operations
        String testString = "hello";
        System.out.println("8. First recurring character: " + firstRecurringCharacter(testString)); // "l"
        System.out.println("9. All recurring characters: " + allRecurringChars(testString)); // [l]

        // Test array conversion
        System.out.println("10. To array: " + Arrays.toString(toArray(set1))); // [1, 2, 3]

        // Test TreeSet operations
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 3, 5, 7));
        System.out.println("11. First: " + getFirst(treeSet)); // 1
        System.out.println("12. Last: " + getLast(treeSet)); // 7
        System.out.println("13. Greater than 3: " + getGreater(treeSet, 3)); // 5
    }

}
