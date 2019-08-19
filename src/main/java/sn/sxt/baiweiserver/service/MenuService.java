package sn.sxt.baiweiserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sn.sxt.baiweiserver.bean.Hr;
import sn.sxt.baiweiserver.bean.Menu;
import sn.sxt.baiweiserver.mapper.MenuMapper;

import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-18 16:42
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Menu> getAllMenus2() {

        return menuMapper.getAllMenus2(((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    public List<Menu> getAllMenus3() {
        return  menuMapper.getAllMenus3();
    }

    public List<Integer> getAllRids(Integer rid) {
     return  menuMapper.getAllRids(rid);
    }
}
