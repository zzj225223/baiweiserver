package sn.sxt.baiweiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.sxt.baiweiserver.bean.Menu;
import sn.sxt.baiweiserver.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class MenuController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public List<Menu> getAllMenu(){
        return menuService.getAllMenus2();

    }
}
