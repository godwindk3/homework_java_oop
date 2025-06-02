package hus.oop.final_2024_2025_rootsolver_basicstatistics_numbersystem_de1.basicstatistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1 a2 a3 ... an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MyIterator iterator = iterator();
        boolean first = true;
        while (iterator.hasNext()) {
            if (!first) {
                sb.append(" ");
            }
            sb.append(iterator.next());
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }
}
