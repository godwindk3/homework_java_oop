package hus.oop.midterm_2023_good_code.students;

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
        for (int i = 0; i < size(); i++) {
            sb.append("[").append(get(i)).append("]");
            if (i < size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
