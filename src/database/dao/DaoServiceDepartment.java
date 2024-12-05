package database.dao;

import models.Department;

import java.util.List;

public interface DaoServiceDepartment {
    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
}
