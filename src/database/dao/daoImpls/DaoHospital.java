package database.dao.daoImpls;

import database.Database;
import database.dao.DaoServiceHospital;
import models.Hospital;
import models.Patient;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DaoHospital implements DaoServiceHospital {

    @Override
    public String addHospital(Hospital hospital) {
        Database.hospitals.add(hospital);
        return "success";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital h:Database.hospitals){
            if (h.getId()==id){
                return h;
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        Hospital hospital=findHospitalById(id);
        return hospital.getPatients();
    }

    @Override
    public String deleteHospitalById(Long id) {
        Hospital hospital=findHospitalById(id);
        if (hospital==null){
            return "There is no hospital with id "+id;
        }
        Database.hospitals.remove(hospital);
        return "Success";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String ,Hospital> hospitalMap=new TreeMap<>();
        for (Hospital hospital:Database.hospitals){
            if (hospital.getAddress().equalsIgnoreCase(address)){
                hospitalMap.put(hospital.getAddress(),hospital);
            }
        }
        return hospitalMap;
    }
}
