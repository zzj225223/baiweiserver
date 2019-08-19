package sn.sxt.baiweiserver.mapper;

import sn.sxt.baiweiserver.bean.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRolesByHrid(Integer hrId);

    List<Role> getAllRoles();
}