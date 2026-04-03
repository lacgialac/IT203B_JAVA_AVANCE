package dao;

import conection.ConnectionDriver;
import model.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
}
