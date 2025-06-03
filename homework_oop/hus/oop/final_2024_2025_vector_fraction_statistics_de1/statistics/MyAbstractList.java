package hus.oop.final_2024_2025_vector_fraction_statistics_de1.statistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1 a2 a3 ... an]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MyIterator it = iterator(0);
        boolean first = true;
        while (it.hasNext()) {
            double v = it.next().doubleValue();
            if (!first) {
                sb.append(" ");
            }
            sb.append(v);
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }
}
