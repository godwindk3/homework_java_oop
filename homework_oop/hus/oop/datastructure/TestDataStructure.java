package hus.oop.datastructure;

import java.util.Random;

public class TestDataStructure {
    public static void main(String[] args) {
        /* TODO
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_DataStructure>.txt (Ví dụ, NguyenVanA_123456_DataStructure.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_DataStructure>.zip (Ví dụ, NguyenVanA_123456_DataStructure.zip),
          nộp lên classroom.
        */
//        testLinkedListQueue();
//        testArrayQueue();
//        testLinkedListStack();
        testArrayStack();
    }

    public static void testArrayStack() {
        /* TODO
         - Sinh ngẫu nhiên ra một số tự nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        Random r = new Random();
        int n = r.nextInt(20, 30);

        MyArrayStack arrayStack = new MyArrayStack();


        for (int i = 0; i < n; i++) {
            arrayStack.push(r.nextInt(20, 30));
        }
        System.out.println("My original stack: ");
        arrayStack.printArrayStack();

        System.out.println("Pop all element: ");
        for (int i = 0; i < n; i++) {
            arrayStack.pop();
            arrayStack.printArrayStack();
        }

    }

    public static void testLinkedListStack() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        Random r = new Random();
        int n = r.nextInt(20, 30);

        MyLinkedListStack linkedListStack = new MyLinkedListStack();

        for (int i = 0; i < n; i++) {
            linkedListStack.push(r.nextInt(20, 30));
        }

        System.out.println("My Stack: " + linkedListStack.toString());

        for (int i = 0; i < n; i++) {
            linkedListStack.pop();
            System.out.println(linkedListStack.toString());
        }

    }

    public static void testArrayQueue() {
        /* TODO
         - Sinh ngẫu nhiên ra một số tự nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */

        Random r = new Random();

        int n = r.nextInt(20, 30);

        MyArrayQueue arrayQueue = new MyArrayQueue(n);

        for (int i = 0; i < n; i++) {
            arrayQueue.enqueue(r.nextInt(20, 30));
        }

        arrayQueue.printArrayQueue();

        for (int i = 0; i < n; i++) {
            System.out.println("Peek: " + arrayQueue.peek());
            System.out.println("Remove element: " + arrayQueue.dequeue());
            arrayQueue.printArrayQueue();
        }

    }

    public static void testLinkedListQueue() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */

        MyLinkedListQueue q = new MyLinkedListQueue();
        Random r = new Random();

        int n = r.nextInt(20, 30);
        System.out.println(n);

        for (int i = 1; i <= n; i++) {
            q.enqueue(r.nextInt(20, 30));
        }

        q.printQueue();

        for (int i = 1; i <= n; i++) {
            q.dequeue();
            q.printQueue();
        }


//        q.enqueue(10);
//        q.enqueue(20);
//
//        q.printQueue();
//
//        q.dequeue();
//        q.dequeue();
//        q.enqueue(30);
//        q.enqueue(40);
//        q.enqueue(50);
//        q.printQueue();
//        System.out.println("Front item is: " + q.peek());
    }
}
