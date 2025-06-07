package hus.oop.final_2024_2025_vector_fraction_statistics_de1.statistics;


import java.util.Random;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        TestStatistics testArray = new TestStatistics(new Statistics(new MyArrayList()));
        testArray.testMyArrayList();

        TestStatistics testLinked = new TestStatistics(new Statistics(new MyLinkedList()));
        testLinked.testMyLinkedList();

        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */
    }

    public void testMyArrayList() {
        Random rand = new Random();
        int length = 30 + rand.nextInt(21); // Sinh ngẫu nhiên từ 30 đến 50
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            list.add(1 + rand.nextDouble() * 19); // Sinh ngẫu nhiên từ 1 đến 20
        }
        Statistics stats = new Statistics(list);

        System.out.println("Dữ liệu gốc: " + list.toString());
        MyList sorted = list.sortIncreasing();
        System.out.println("Dữ liệu sắp xếp: " + sorted.toString());
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Kỳ vọng: " + stats.mean());
        System.out.println("Phương sai: " + stats.variance());
        double searchValue = list.iterator(0).next().doubleValue();
        System.out.println("Tìm kiếm " + searchValue + ": " + stats.search(searchValue));
        double[] ranks = stats.rank();
        System.out.print("Rank: [");
        for (double r : ranks) {
            System.out.print(r + " ");
        }
        System.out.println("]");
    }

    public void testMyLinkedList() {
        Random rand = new Random();
        int length = 30 + rand.nextInt(21); // Sinh ngẫu nhiên từ 30 đến 50
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            list.add(1 + rand.nextDouble() * 19); // Sinh ngẫu nhiên từ 1 đến 20
        }
        Statistics stats = new Statistics(list);

        System.out.println("Dữ liệu gốc: " + list.toString());
        MyList sorted = list.sortIncreasing();
        System.out.println("Dữ liệu sắp xếp: " + sorted.toString());
        System.out.println("Max: " + stats.max());
        System.out.println("Min: " + stats.min());
        System.out.println("Kỳ vọng: " + stats.mean());
        System.out.println("Phương sai: " + stats.variance());
        double searchValue = list.iterator(0).next().doubleValue();
        System.out.println("Tìm kiếm " + searchValue + ": " + stats.search(searchValue));
        double[] ranks = stats.rank();
        System.out.print("Rank: [");
        for (double r : ranks) {
            System.out.print(r + " ");
        }
        System.out.println("]");
    }
}