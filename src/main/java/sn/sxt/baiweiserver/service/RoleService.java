package sn.sxt.baiweiserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sxt.baiweiserver.bean.Role;
import sn.sxt.baiweiserver.mapper.RoleMapper;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-22 10:57
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }
}
