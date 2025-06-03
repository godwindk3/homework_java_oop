package hus.oop.midterm_2022_2023_sortstrategy_iterator_decorator.decorator;

import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class BreadStore {
    private List<Bread> breads;

    public BreadStore() {
        breads = new LinkedList<>();
    }

    /**
     * Khởi tạo cửa hàng với 30 bánh mì:
     * 5 ThickcrustBread chỉ có cheese,
     * 5 ThickcrustBread chỉ có olives,
     * 5 ThickcrustBread có cả cheese và olives,
     * 5 ThincrustBread chỉ có cheese,
     * 5 ThincrustBread chỉ có olives,
     * 5 ThincrustBread có cả cheese và olives.
     */
    public void init() {
        // ThickcrustBread
        for (int i = 0; i < 5; i++) {
            breads.add(new Cheese(new ThickcrustBread())); // Chỉ cheese
            breads.add(new Olives(new ThickcrustBread())); // Chỉ olives
            breads.add(new Cheese(new Olives(new ThickcrustBread()))); // Cả cheese và olives
        }

        // ThincrustBread
        for (int i = 0; i < 5; i++) {
            breads.add(new Cheese(new ThincrustBread())); // Chỉ cheese
            breads.add(new Olives(new ThincrustBread())); // Chỉ olives
            breads.add(new Cheese(new Olives(new ThincrustBread()))); // Cả cheese và olives
        }
    }

    /**
     * Thêm bánh mì vào cửa hàng.
     */
    public void add(Bread bread) {
        breads.add(bread);
    }

    /**
     * Bán bánh mì có giá bằng giá bánh mì yêu cầu, lấy bánh đầu tiên phù hợp.
     * Trả về true nếu bán được, false nếu không còn bánh phù hợp.
     */
    public boolean sell(Bread bread) {
        double targetCost = bread.cost();
        for (int i = 0; i < breads.size(); i++) {
            if (breads.get(i).cost() == targetCost) {
                breads.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * In ra những bánh mì còn trong cửa hàng.
     */
    public void print() {
        if (breads.isEmpty()) {
            System.out.println("No breads in store.");
            return;
        }
        for (Bread bread : breads) {
            System.out.printf("%s, Cost: %.2f\n", bread.getDescription(), bread.cost());
        }
    }

    /**
     * Sắp xếp bánh mì theo giá, không thay đổi danh sách gốc.
     * order = true: tăng dần, order = false: giảm dần.
     */
    public List<Bread> sort(boolean order) {
        List<Bread> sortedBreads = new LinkedList<>(breads);
        Comparator<Bread> comparator = (b1, b2) -> Double.compare(b1.cost(), b2.cost());
        if (!order) {
            comparator = comparator.reversed();
        }
        sortedBreads.sort(comparator);
        return sortedBreads;
    }

    /**
     * Lọc howMany bánh mì có giá cao nhất (order = true) hoặc thấp nhất (order = false).
     */
    public List<Bread> filter(int howMany, boolean order) {
        List<Bread> sortedBreads = sort(order); // Sắp xếp theo thứ tự yêu cầu
        int limit = Math.min(howMany, sortedBreads.size());
        return sortedBreads.subList(0, limit);
    }

    public static void main(String args[]) {
        BreadStore breadStore = new BreadStore();
        breadStore.init();

        // Demo: Thêm bánh mì
        System.out.println("Adding some breads:");
        breadStore.add(new Cheese(new ThickcrustBread()));
        breadStore.add(new Olives(new ThincrustBread()));
        breadStore.add(new Cheese(new Olives(new ThickcrustBread())));

        // Demo: Bán bánh mì
        System.out.println("\nSelling some breads:");
        System.out.println("Sell Thickcrust with cheese: " + breadStore.sell(new Cheese(new ThickcrustBread())));
        System.out.println("Sell Thincrust with olives: " + breadStore.sell(new Olives(new ThincrustBread())));
        System.out.println("Sell Thickcrust with cheese and olives: " + breadStore.sell(new Cheese(new Olives(new ThickcrustBread()))));

        // Demo: In danh sách bánh mì theo thứ tự giá tăng dần
        System.out.println("\nBreads in store (sorted by cost ascending):");
        List<Bread> sortedBreads = breadStore.sort(true);
        for (Bread bread : sortedBreads) {
            System.out.printf("%s, Cost: %.2f\n", bread.getDescription(), bread.cost());
        }

        // Demo: Lọc 10 bánh mì có giá thấp nhất
        System.out.println("\nTop 10 cheapest breads:");
        List<Bread> cheapestBreads = breadStore.filter(10, false);
        for (Bread bread : cheapestBreads) {
            System.out.printf("%s, Cost: %.2f\n", bread.getDescription(), bread.cost());
        }
    }
}
