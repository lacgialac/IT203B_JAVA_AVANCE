// DiscountStrategy (interface)
interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

// PercentageDiscount
class PercentageDiscount implements DiscountStrategy {
    double percent;

    PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount * (1 - percent / 100);
    }
}

// FixedDiscount
class FixedDiscount implements DiscountStrategy {
    double amount;

    FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount - amount;
    }
}

// NoDiscount
class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}

// HolidayDiscount (thêm mới, không sửa code cũ)
class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.85; // giảm 15%
    }
}

// OrderCalculator
class OrderCalculator {
    double total;
    DiscountStrategy discountStrategy;

    OrderCalculator(double total, DiscountStrategy discountStrategy) {
        this.total = total;
        this.discountStrategy = discountStrategy;
    }

    double calculateFinalAmount() {
        return discountStrategy.applyDiscount(total);
    }
}

// Main
public class Main {
    public static void main(String[] args) {

        double total = 1000000;

        // Percentage 10%
        OrderCalculator oc1 = new OrderCalculator(total, new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + (long)oc1.calculateFinalAmount());

        // Fixed 50k
        OrderCalculator oc2 = new OrderCalculator(total, new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + (long)oc2.calculateFinalAmount());

        // NoDiscount
        OrderCalculator oc3 = new OrderCalculator(total, new NoDiscount());
        System.out.println("Số tiền sau giảm: " + (long)oc3.calculateFinalAmount());

        // Holiday 15% (không sửa code cũ)
        OrderCalculator oc4 = new OrderCalculator(total, new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + (long)oc4.calculateFinalAmount());
    }
}