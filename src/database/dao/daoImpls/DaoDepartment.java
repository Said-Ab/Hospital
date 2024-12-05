package database.dao.daoImpls;

import database.Database;
import database.dao.DaoGenericService;
import database.dao.DaoServiceDepartment;
import models.Department;
import models.Hospital;

import java.util.List;

public class DaoDepartment implements DaoGenericService<Department>, DaoServiceDepartment {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId() == id) {
                return hospital.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equalsIgnoreCase(name)) {
                    return department;
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId() == hospitalId) {
                hospital.getDepartments().add(department);
                return "Success";
            }
        }
        return "Failure";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId() == id) {
                    hospital.getDepartments().remove(department);
                    break;
                }
            }
        }
        System.out.println("Not found department like that");
    }

    @Override
    public String updateById(Long id, Department department) {
        for (Hospital hospital : Database.hospitals) {
            for (Department d : hospital.getDepartments()) {
                if (d.getId() == id) {
                    d.setDepartmentName(department.getDepartmentName());
                    return "Success";
                }
            }
        }
        return "Failure";
    }
}
