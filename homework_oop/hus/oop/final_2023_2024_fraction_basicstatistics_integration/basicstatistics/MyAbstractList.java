package hus.oop.final_2023_2024_fraction_basicstatistics_integration.basicstatistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        MyIterator iterator = iterator();
        while (iterator.hasNext()) {
            sb.append("[").append(iterator.next()).append("] ");
        }
        return sb.toString().trim();
    }
}
