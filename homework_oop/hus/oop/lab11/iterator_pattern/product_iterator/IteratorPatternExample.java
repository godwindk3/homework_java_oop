package hus.oop.lab11.iterator_pattern.product_iterator;

public class IteratorPatternExample {
    public static void main(String[] args) {
        ProductCatalog productCatalog = new ProductCatalog();

        Iterator it = productCatalog.getIterator();

        while (it.hasNext()) {
            System.out.println("Product: " + it.next());
        }
    }
}
