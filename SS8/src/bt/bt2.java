package bt;
import java.util.Scanner;

// 1. Interface cảm biến mới
interface TemperatureSensor {
    double getTemperatureCelsius();
}

// 2. Cảm biến cũ
class OldThermometer {
    public int getTemperatureFahrenheit() {
        // Giả lập đọc cảm biến, ví dụ 78°F
        return 78;
    }
}

// 3. Adapter để chuyển từ OldThermometer sang TemperatureSensor
class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        int f = oldThermometer.getTemperatureFahrenheit();
        return (f - 32) * 5.0 / 9.0;
    }
}

// 4. Các thiết bị trong nhà
class Light {
    public void turnOff() { System.out.println("FACADE: Tắt đèn"); }
    public void turnOn() { System.out.println("FACADE: Bật đèn"); }
}

class Fan {
    public void turnOff() { System.out.println("FACADE: Tắt quạt"); }
    public void lowSpeed() { System.out.println("FACADE: Quạt chạy tốc độ thấp"); }
}

class AirConditioner {
    public void turnOff() { System.out.println("FACADE: Tắt điều hòa"); }
    public void setTemperature(int temp) { System.out.println("FACADE: Điều hòa set " + temp + "°C"); }
}

// 5. Facade: Đơn giản hóa việc điều khiển
class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner ac;
    private TemperatureSensor sensor;

    public SmartHomeFacade(Light light, Fan fan, AirConditioner ac, TemperatureSensor sensor) {
        this.light = light;
        this.fan = fan;
        this.ac = ac;
        this.sensor = sensor;
    }

    public void leaveHome() {
        light.turnOff();
        fan.turnOff();
        ac.turnOff();
    }

    public void sleepMode() {
        light.turnOff();
        ac.setTemperature(28);
        fan.lowSpeed();
    }

    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.printf("Nhiệt độ hiện tại: %.1f°C%n", temp);
    }
}

// 6. Chương trình console
public class bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Giả lập tạo các thiết bị
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Chọn cảm biến cũ và dùng adapter
        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade facade = new SmartHomeFacade(light, fan, ac, sensor);

        while (true) {
            System.out.println("\n--- Hệ thống nhà thông minh ---");
            System.out.println("1. Xem nhiệt độ hiện tại");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // đọc bỏ dòng mới

            switch (choice) {
                case 1:
                    facade.getCurrentTemperature();
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}