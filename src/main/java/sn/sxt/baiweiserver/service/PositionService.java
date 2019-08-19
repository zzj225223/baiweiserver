package sn.sxt.baiweiserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sxt.baiweiserver.bean.Position;
import sn.sxt.baiweiserver.bean.RespPageBean;
import sn.sxt.baiweiserver.mapper.PositionMapper;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public RespPageBean getAllPosition(Integer page,Integer size) {
        if (page!=null&&size!=null) {
            page = (page - 1) * size;
        }
      List<Position> list= positionMapper.getAllPosition(page,size);
      RespPageBean respPageBean=new RespPageBean();
      respPageBean.setData(list);
      respPageBean.setTotal(positionMapper.getTotal());
        return respPageBean;
    }

    public Integer deletePositionById(Integer id) {

        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer addPosition(Position position) {
        position.setCreatedate(new Date());
        position.setEnabled(true);
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {

        return positionMapper.updateByPrimaryKeySelective(position);

    }
}
