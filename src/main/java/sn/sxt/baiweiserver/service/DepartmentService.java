package sn.sxt.baiweiserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sxt.baiweiserver.bean.Department;
import sn.sxt.baiweiserver.mapper.DepartmentMapper;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepts() {
        return departmentMapper.getDeptsByPid(-1);
    }

    public void deleteDepartmentById(Department department) {

        departmentMapper.deleteDepartmentById(department);
    }

    public void addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }

    public List<Department> getAllDepartments() {
      return  departmentMapper.getAllDepartments();
    }
}
