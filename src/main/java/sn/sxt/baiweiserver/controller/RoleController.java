package sn.sxt.baiweiserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.sxt.baiweiserver.bean.Menu;
import sn.sxt.baiweiserver.bean.Role;
import sn.sxt.baiweiserver.service.MenuService;
import sn.sxt.baiweiserver.service.RoleService;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-22 10:56
 */
@RestController
@RequestMapping("/system/basic/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/menu")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus3();
    }

    @GetMapping("/mids")
    public List<Integer> getAllRids(Integer rid) {
        return menuService.getAllRids(rid);
    }
}
