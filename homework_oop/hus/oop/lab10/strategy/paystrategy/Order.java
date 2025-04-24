package hus.oop.lab10.strategy.paystrategy;

public class Order {
    private static Order instance;
    private int totalCost = 0;
    private boolean isClosed = false;

//    public void processOrderUsingPaypal(PayByPaypal paypal) {
//        paypal.collectPaymentDetails();
//    }
//
//    public void processOrderUsingCreditCard(PayByCreditCard creditCard) {
//        creditCard.collectPaymentDetails();
//    }

    private Order() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
    }

    public static Order getInstance() { // Apply Singleton Pattern
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void processOrder(PayStrategy strategy) { // Apply Strategy pattern
        strategy.collectPaymentDetails();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }


}
