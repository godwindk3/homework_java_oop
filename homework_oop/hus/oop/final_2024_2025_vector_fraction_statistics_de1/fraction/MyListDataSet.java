package hus.oop.final_2024_2025_vector_fraction_statistics_de1.fraction;

import java.util.List;
import java.util.ArrayList;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        fractions = new ArrayList<>();
    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        this.fractions = new ArrayList<>(fractions);
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            return false;
        }
        fractions.add(index, fraction);
        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        fractions.add(fraction);
        return true;
    }

    @Override
    public MyListDataSet toSimplify() {
        List<MyFraction> simplified = new ArrayList<>();
        for (MyFraction frac : fractions) {
            MyFraction copy = new MyFraction(frac);
            copy.simplify();
            simplified.add(copy);
        }
        return new MyListDataSet(simplified);
    }

    public MyListDataSet sortIncreasing() {
        List<MyFraction> sorted = new ArrayList<>(fractions);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).compareTo(sorted.get(j)) > 0) {
                    MyFraction temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return new MyListDataSet(sorted);
    }

    public MyListDataSet sortDecreasing() {
        List<MyFraction> sorted = new ArrayList<>(fractions);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).compareTo(sorted.get(j)) < 0) {
                    MyFraction temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return new MyListDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < fractions.size(); i++) {
            sb.append(fractions.get(i).toString());
            if (i < fractions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }
}