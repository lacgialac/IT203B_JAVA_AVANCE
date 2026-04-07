package model;


public class Doctor {
    private  int id;
    private  String full_name;
    private String specialty;
    private int expYears;
    private double baseSalary;
    private String password;

    public Doctor(int id, String full_name, String specialty, int expYears, double baseSalary, String password) {
        this.id = id;
        this.full_name = full_name;
        this.specialty = specialty;
        this.expYears = expYears;
        this.baseSalary = baseSalary;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getExpYears() {
        return expYears;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
