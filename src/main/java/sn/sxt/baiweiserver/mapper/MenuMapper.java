package sn.sxt.baiweiserver.mapper;

import sn.sxt.baiweiserver.bean.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllMenus();

    List<Menu> getAllMenus2(Integer hrid);

    List<Menu> getAllMenus3();

    List<Integer> getAllRids(Integer rid);
}