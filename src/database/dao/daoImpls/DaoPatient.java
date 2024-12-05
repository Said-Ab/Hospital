package database.dao.daoImpls;

import database.Database;
import database.dao.DaoGenericService;
import database.dao.DaoServicePatient;
import models.Hospital;
import models.Patient;

import java.util.*;

public class DaoPatient implements DaoGenericService<Patient>, DaoServicePatient {
    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId() == hospitalId) {
                hospital.getPatients().add(patient);
                return "Success";
            }
        }
        return "Failure";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    hospital.getPatients().remove(patient);
                }
            }
        }

    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Hospital hospital : Database.hospitals) {
            for (Patient p : hospital.getPatients()) {
                if (p.getId() == id) {
                    p.setFirstName(patient.getFirstName());
                    p.setLastName(patient.getLastName());
                    p.setAge(patient.getAge());
                    p.setGender(patient.getGender());
                    return "Success";
                }
            }
        }
        return "Failure";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    return patient;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer,Patient>patientMap=new TreeMap<>();
        for (Hospital hospital:Database.hospitals){
            for (Patient patient:hospital.getPatients()){
                if (patient.getAge()==age){
                    patientMap.put(patient.getAge(),patient);
                }
            }
        }
        return patientMap;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        ArrayList<Patient>patients=new ArrayList<>();
        for (Hospital hospital:Database.hospitals){
            for (Patient patient:hospital.getPatients()){
                patients.add(patient);
            }
        }
        Comparator<Patient>comparator=Comparator.comparing(Patient::getAge);
        if (ascOrDesc.equalsIgnoreCase("desc")){
patients.sort(comparator.reversed());}
        return patients;
    }
}
