package model;

public class Patient {
    protected int id;
    protected String full_name;
    protected int age ;
    protected String diagnos;

    public Patient(int id, String full_name, int age, String diagnos){
        this.id=id;
        this.full_name=full_name;
        this.age=age;
        this.diagnos=diagnos;
    }

    public Patient() {
    }

    public int getAge() {
        return age;
    }

    public String getFull_name() {
        return full_name;
    }

    public int getId() {
        return id;
    }

    public String getDiagnos() {
        return diagnos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDiagnos(String diagnos) {
        this.diagnos = diagnos;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
