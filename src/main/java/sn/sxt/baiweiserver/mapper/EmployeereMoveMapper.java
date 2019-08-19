package sn.sxt.baiweiserver.mapper;

import sn.sxt.baiweiserver.bean.EmployeereMove;

public interface EmployeereMoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeereMove record);

    int insertSelective(EmployeereMove record);

    EmployeereMove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeereMove record);

    int updateByPrimaryKey(EmployeereMove record);
}