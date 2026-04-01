import java.util.*;

// Product
class Product {
    String id, name;
    double price;

    Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// Customer
class Customer {
    String name, email, address;

    Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}

// Order
class Order {
    String id;
    Customer customer;
    Map<Product, Integer> items = new HashMap<>();
    double total;

    Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    void addProduct(Product p, int quantity) {
        items.put(p, quantity);
    }
}

// OrderCalculator
class OrderCalculator {
    double calculateTotal(Order order) {
        double sum = 0;
        for (Product p : order.items.keySet()) {
            sum += p.price * order.items.get(p);
        }
        return sum;
    }
}

// OrderRepository
class OrderRepository {
    void save(Order order) {
        System.out.println("Đã lưu đơn hàng " + order.id);
    }
}

// EmailService
class EmailService {
    void sendEmail(String email, String message) {
        System.out.println("Đã gửi email đến " + email + ": " + message);
    }
}

// Main
public class Main {
    public static void main(String[] args) {

        // Tạo sản phẩm
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuột", 300000);
        System.out.println("Đã thêm sản phẩm SP01, SP02");

        // Tạo khách hàng
        Customer c = new Customer("Nguyễn Văn A", "a@example.com", "HN");
        System.out.println("Đã thêm khách hàng");

        // Tạo đơn hàng
        Order order = new Order("ORD001", c);
        order.addProduct(p1, 1);
        order.addProduct(p2, 2);
        System.out.println("Đơn hàng ORD001 được tạo");

        // Tính tổng tiền
        OrderCalculator calc = new OrderCalculator();
        order.total = calc.calculateTotal(order);
        System.out.println("Tổng tiền: " + (long)order.total);

        // Lưu đơn hàng
        OrderRepository repo = new OrderRepository();
        repo.save(order);

        // Gửi email
        EmailService email = new EmailService();
        email.sendEmail(c.email, "Đơn hàng ORD001 đã được tạo");
    }
}