package Entry;

public class Order {
    protected String orderId;
    protected String customerName;
    protected int totalAmount ;
    protected  String status;
    protected String orderDate;

    public Order(String orderId, String customerName, int totalAmount, String status, String orderDate){
        this.orderId=orderId;
        this.customerName=customerName;
        this.totalAmount=totalAmount;
        this.status=status;
        this.orderDate=orderDate;

    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }

    public void displayData() {
        System.out.printf("%s | %s | %d | %s | %s\n",
                orderId, customerName, totalAmount, status, orderDate);
    }
}
