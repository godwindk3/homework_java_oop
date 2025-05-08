package hus.oop.lab11.iterator_pattern.product_iterator;

public class ProductCatalog {
    private String[] productCatalog = {"Main Board", "CPU", "GPU", "RAM", "CASE", "PSU"};

    public Iterator getIterator() {
        return new ProductIterator(productCatalog);
    }
}
