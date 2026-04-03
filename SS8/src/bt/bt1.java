package bt;

import java.util.Scanner;

// 1. Singleton: Quản lý kết nối phần cứng
class HardwareConnection {
    private static HardwareConnection instance;

    private HardwareConnection() {
        // private constructor để không thể tạo trực tiếp
    }

    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
        }
        return instance;
    }

    public void connect() {
        System.out.println("HardwareConnection: Kết nối phần cứng.");
    }

    public void disconnect() {
        System.out.println("HardwareConnection: Ngắt kết nối phần cứng.");
    }
}

// 2. Interface Device
interface Device {
    void turnOn();
    void turnOff();
}

// 3. Các lớp thiết bị cụ thể
class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}

class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quạt: Bật quay.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}

class AirConditioner implements Device {
    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Bật lạnh.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}

// 4. Abstract Factory
abstract class DeviceFactory {
    public abstract Device createDevice();
}

// 5. Các Factory cụ thể
class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("LightFactory: Đã tạo đèn mới.");
        return new Light();
    }
}

class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("FanFactory: Đã tạo quạt mới.");
        return new Fan();
    }
}

class AirConditionerFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("AirConditionerFactory: Đã tạo điều hòa mới.");
        return new AirConditioner();
    }
}

// 6. Chương trình console
public class bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HardwareConnection connection = null;
        Device device = null;

        while (true) {
            System.out.println("\n--- Hệ thống nhà thông minh ---");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị mới");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // đọc bỏ dòng mới

            switch (choice) {
                case 1:
                    connection = HardwareConnection.getInstance();
                    break;
                case 2:
                    System.out.println("Chọn loại thiết bị: 1. Đèn  2. Quạt  3. Điều hòa");
                    System.out.print("Chọn: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    DeviceFactory factory = null;
                    if (type == 1) factory = new LightFactory();
                    else if (type == 2) factory = new FanFactory();
                    else if (type == 3) factory = new AirConditionerFactory();

                    if (factory != null) {
                        device = factory.createDevice();
                    } else {
                        System.out.println("Loại thiết bị không hợp lệ.");
                    }
                    break;
                case 3:
                    if (device != null) device.turnOn();
                    else System.out.println("Chưa có thiết bị nào để bật.");
                    break;
                case 4:
                    if (device != null) device.turnOff();
                    else System.out.println("Chưa có thiết bị nào để tắt.");
                    break;
                case 5:
                    if (connection != null) connection.disconnect();
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}