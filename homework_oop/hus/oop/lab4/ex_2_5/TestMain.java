package hus.oop.lab4.ex_2_5;

public class TestMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Phong", 'm');
        Account account1 = new Account(1, customer1, 100000);

        System.out.println(account1);
        account1.setBalance(20000);
        System.out.println(account1);
        account1.deposit(500);
        System.out.println(account1);
        account1.withdraw(10000000);
        System.out.println(account1);
        System.out.println(account1.getCustomer().toString());
        account1.withdraw(5000);
        System.out.println("After withdraw 5000$:");
        System.out.println(account1);
    }
}
