package sn.sxt.baiweiserver.mapper;

import org.apache.ibatis.annotations.Param;
import sn.sxt.baiweiserver.bean.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPosition(@Param("page") Integer page,@Param("size") Integer size);

    Integer getTotal();
}