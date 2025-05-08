package hus.oop.lab11.iterator_pattern.product_iterator;

public class ProductIterator implements Iterator {
    int index = 0;
    private String[] productCatalog;

    public ProductIterator(String[] productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public boolean hasNext() {
        return index < productCatalog.length;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return productCatalog[index++];
        }
        return null;
    }

}
