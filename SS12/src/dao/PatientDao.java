package dao;

import Prescentation.PatientPresentation;
import conection.ConnectionDriver;
import model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    private List<Patient> Listp;

    public List<Patient> findPatient() {
        Listp = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionDriver.getConnection();
            String query = "SELECT *FROM Patients";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Patient newPatient = new Patient();
                newPatient.setId(resultSet.getInt("patient_id"));
                newPatient.setFull_name(resultSet.getString("full_name"));
                newPatient.setAge(resultSet.getInt("age"));
                newPatient.setDiagnos(resultSet.getString("diagnos"));
                Listp.add(newPatient);
            }
        } catch (Exception e) {

        } finally {

        }
        return Listp;
    }

    public void insertPatient(Patient p){
        try{
            Connection connection= ConnectionDriver.getConnection();
            String sql="Insert INTO Patients(patient_id, full_name, age, diagnos)values (?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql);

            ps.setInt(1, p.getId());
            ps.setString(2, p.getFull_name());
            ps.setInt(3, p.getAge());
            ps.setString(4, p.getDiagnos());

            ps.executeUpdate();
            System.out.println("đã thêm thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
