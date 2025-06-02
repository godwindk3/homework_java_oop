package hus.oop.final_2022_2023_mymath_studentmanager_studentmanager2_de2.studentmanager2;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        MyIterator iterator = this.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
