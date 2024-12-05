package service;

import models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge(int age);
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
