import java.util.Scanner;

// Vehicle
interface Vehicle {
    void displayInfo();
}

// Sedan
class Sedan implements Vehicle {
    public void displayInfo() {
        System.out.println("Xe sedan: 4 chỗ, tiết kiệm nhiên liệu");
    }
}

// SUV
class SUV implements Vehicle {
    public void displayInfo() {
        System.out.println("Xe SUV: 7 chỗ, mạnh mẽ, phù hợp địa hình");
    }
}

// Truck
class Truck implements Vehicle {
    public void displayInfo() {
        System.out.println("Xe tải: Tải trọng lớn, phù hợp chở hàng");
    }
}

// ElectricCar (thêm mới)
class ElectricCar implements Vehicle {
    public void displayInfo() {
        System.out.println("Xe điện: thân thiện môi trường, sạc điện");
    }
}

// VehicleFactory
abstract class VehicleFactory {
    abstract Vehicle createVehicle();

    void deliverVehicle() {
        Vehicle v = createVehicle();
        v.displayInfo();
    }
}

// SedanFactory
class SedanFactory extends VehicleFactory {
    Vehicle createVehicle() {
        System.out.println("SedanFactory: Đang tạo xe sedan");
        return new Sedan();
    }
}

// SUVFactory
class SUVFactory extends VehicleFactory {
    Vehicle createVehicle() {
        System.out.println("SUVFactory: Đang tạo xe SUV");
        return new SUV();
    }
}

// TruckFactory
class TruckFactory extends VehicleFactory {
    Vehicle createVehicle() {
        System.out.println("TruckFactory: Đang tạo xe tải");
        return new Truck();
    }
}

// ElectricCarFactory
class ElectricCarFactory extends VehicleFactory {
    Vehicle createVehicle() {
        System.out.println("ElectricCarFactory: Đang tạo xe điện");
        return new ElectricCar();
    }
}

// Main
public class btth2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn loại xe:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Truck");
        System.out.println("4. ElectricCar");

        int choice = sc.nextInt();
        VehicleFactory factory = null;

        switch (choice) {
            case 1:
                factory = new SedanFactory();
                break;
            case 2:
                factory = new SUVFactory();
                break;
            case 3:
                factory = new TruckFactory();
                break;
            case 4:
                factory = new ElectricCarFactory();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }

        factory.deliverVehicle();
    }
}