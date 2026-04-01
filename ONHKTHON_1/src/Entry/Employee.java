package Entry;

public class Employee {
    protected String empId;
    protected String empName;
    protected double salary;
    protected String department;
    protected  String joinDate;

    public Employee(String empId,String empName,double salary,String department, String joinDate ){
        this.empId=empId;
        this.empName=empName;
        this.salary=salary;
        this.department=department;
        this.joinDate=joinDate;
    }


}
