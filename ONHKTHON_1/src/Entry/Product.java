package Entry;

public class Product {
    protected String productId;
    protected String productName;
    protected double price ;
    protected String category;
    protected int quantity;

    public Product(String productId, String productName, double price, String category, int quantity){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.category=category;
        this.quantity=quantity;
    }


}
