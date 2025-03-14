public class order {
    private int orderId;
    private String orderName;
    private int orderQty;
    private double orderPrice;
    private double discount;
    private double totalPrice;
    public order(int orderId, String orderName, int orderQty, double orderPrice) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;
        this.discount = 0.0;
        this.totalPrice = CalTP();
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double CalTP() {
        return orderQty * orderPrice;
    }
    public void applyDiscount() {
        this.discount = 0.05 * totalPrice;
        this.totalPrice -= discount;
    }
    public void display() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Name: " + orderName);
        System.out.println("Order Quantity: " + orderQty);
        System.out.println("Order Price: " + orderPrice);
        System.out.println("Discount: " + discount);
        System.out.println("Total Price: " + totalPrice);
    }
    public static void main(String[] args) {
        order order1 = new order(1, "Laptop", 2, 500.0);
        order order2 = new order(2, "Smartphone", 3, 300.0);
        order1.applyDiscount();
        order2.applyDiscount();
        System.out.println("Order 1 Details:");
        order1.display();
        System.out.println("\nOrder 2 Details:");
        order2.display();
        if (order1.getTotalPrice() > order2.getTotalPrice()) {
            System.out.println("\nOrder 1 has more price:");
            order1.display();
        } else {
            System.out.println("\nOrder 2 has more price:");
            order2.display();
        }
    }
}