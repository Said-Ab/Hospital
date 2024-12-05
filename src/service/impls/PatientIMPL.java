package service.impls;

import database.dao.daoImpls.DaoPatient;
import models.Patient;
import service.GenericService;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientIMPL implements GenericService<Patient>, PatientService {
    DaoPatient daoPatient=new DaoPatient();
    @Override
    public String add(Long hospitalId, Patient patient) {
        return daoPatient.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
daoPatient.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return daoPatient.updateById(id,patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return daoPatient.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        return daoPatient.getPatientByAge(age);
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return daoPatient.sortPatientsByAge(ascOrDesc);
    }
}
