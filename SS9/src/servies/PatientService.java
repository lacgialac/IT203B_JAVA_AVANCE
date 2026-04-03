package servies;

import dao.PatientDao;
import model.Patient;

import java.util.List;

public class PatientService {
private static PatientService patientService;

    private PatientDao PatientDao = new PatientDao();
    public List<Patient> getPatient(){
        return PatientDao.findPatient();
    }


}
