package database.dao.daoImpls;

import database.Database;
import database.dao.DaoGenericService;
import database.dao.DaoServiceDoctor;
import models.Department;
import models.Doctor;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DaoDoctor implements DaoGenericService<Doctor>, DaoServiceDoctor {
    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (Hospital hospital: Database.hospitals){
            if (hospital.getId()==hospitalId){
                hospital.getDoctors().add(doctor);
                return "Success";
            }
        }
        return "Failure";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital:Database.hospitals){
            for (Doctor doctor:hospital.getDoctors()){
                if (doctor.getId()==id){
                    hospital.getDoctors().remove(doctor);
                }
            }
            for (Department department:hospital.getDepartments()){
                for (Doctor doctor:department.getDoctorList()){
                    if (doctor.getId()==id){
                        department.getDoctorList().remove(doctor);
                    }
                }
            }
        }

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (Hospital hospital:Database.hospitals){
            for (Doctor doctor1:hospital.getDoctors()){
                if (doctor1.getId()==id){
                    doctor1.setFirstNAme(doctor.getFirstNAme());
                    doctor1.setLastName(doctor.getLastName());
                    doctor1.setGender(doctor.getGender());
                    doctor1.setExperienceYear(doctor.getExperienceYear());

                }
            }
            for (Department department:hospital.getDepartments()){
                for (Doctor doctor1:department.getDoctorList()){
                    if (doctor1.getId()==id){
                        doctor1.setFirstNAme(doctor.getFirstNAme());
                        doctor1.setLastName(doctor.getLastName());
                        doctor1.setGender(doctor.getGender());
                        doctor1.setExperienceYear(doctor.getExperienceYear());
                    }
                }
            }
        }
        return "";
    }
    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital:Database.hospitals){
            for (Doctor doctor:hospital.getDoctors()){
                if (doctor.getId()==id){
                    return doctor;
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital:Database.hospitals){
            for (Department department:hospital.getDepartments()){
                if (department.getId().equals(departmentId)){
                    List<Doctor> doctors = new ArrayList<>();
                    for (Long doctorId:doctorsId){
                        Doctor doctor = findDoctorById(doctorId);
                        if (doctor!=null){
                            doctors.add(doctor);
                        }
                    }department.getDoctorList().addAll(doctors);
                    return "Successfully assigned";
                }
            }
        }return "Try again";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital:Database.hospitals){
            if(hospital.getId()==id){
                return hospital.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital:Database.hospitals){
            for (Department department:hospital.getDepartments()){
                if (department.getId()==id){
                    return department.getDoctorList();
                }
            }
        }
        return null;
    }


}
