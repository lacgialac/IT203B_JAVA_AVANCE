public class btth1 {

    // DatabaseConnection (Singleton)
    static class DatabaseConnection {
        private static DatabaseConnection instance;

        private DatabaseConnection() {
            System.out.println("Khởi tạo kết nối CSDL");
        }

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public void query(String sql) {
            System.out.println("Thực thi: " + sql);
        }
    }

    // Employee
    static class Employee {
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        String getName() {
            return name;
        }
    }

    // EmployeeRepository
    static class EmployeeRepository {
        private DatabaseConnection connection;

        EmployeeRepository() {
            connection = DatabaseConnection.getInstance();
        }

        void save(Employee emp) {
            System.out.println("Lưu nhân viên: " + emp.getName());
            connection.query("INSERT INTO employees VALUES (...)");
        }

        void findAll() {
            System.out.println("Lấy danh sách nhân viên");
            connection.query("SELECT * FROM employees");
        }

        DatabaseConnection getConnection() {
            return connection;
        }
    }

    // main
    public static void main(String[] args) {

        EmployeeRepository repo1 = new EmployeeRepository();
        EmployeeRepository repo2 = new EmployeeRepository();

        repo1.save(new Employee(1, "An", 1000));
        repo2.findAll();

        // kiểm tra dùng chung instance
        System.out.println("repo1 connection: " + repo1.getConnection().hashCode());
        System.out.println("repo2 connection: " + repo2.getConnection().hashCode());
    }
}