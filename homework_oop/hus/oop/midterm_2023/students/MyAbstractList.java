package hus.oop.midterm_2023.students;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     *
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */

    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        MyIterator it = iterator();
        while (it.hasNext()) {
            Object element = it.next();
            sb.append("[").append(element).append("]");
        }
        return sb.toString().trim();
    }
}
