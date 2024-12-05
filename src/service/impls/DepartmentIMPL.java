package service.impls;

import database.dao.daoImpls.DaoDepartment;
import models.Department;
import service.DepartmentService;
import service.GenericService;

import java.util.List;

public class DepartmentIMPL implements GenericService<Department>, DepartmentService {
    DaoDepartment daoDepartment=new DaoDepartment();
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return daoDepartment.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return daoDepartment.findDepartmentByName(name);
    }

    @Override
    public String add(Long hospitalId, Department department) {

        return daoDepartment.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
daoDepartment.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
        return daoDepartment.updateById(id,department);
    }
}
