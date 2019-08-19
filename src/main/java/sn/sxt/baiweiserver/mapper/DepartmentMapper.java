package sn.sxt.baiweiserver.mapper;

import sn.sxt.baiweiserver.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getDeptsByPid(Integer pid);

    void deleteDepartmentById(Department department);

    void addDep(Department department);

    List<Department> getAllDepartments();
}