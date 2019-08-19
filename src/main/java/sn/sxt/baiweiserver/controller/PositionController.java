package sn.sxt.baiweiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sn.sxt.baiweiserver.bean.Position;
import sn.sxt.baiweiserver.bean.RespBean;
import sn.sxt.baiweiserver.bean.RespPageBean;
import sn.sxt.baiweiserver.config.POIUtils;
import sn.sxt.baiweiserver.service.PositionService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/system/basic/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public RespPageBean getAllPosition(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size) {
        return positionService.getAllPosition(page,size);
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败");

    }
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("职位添加成功");
        }
        return RespBean.error("职位添加失败");

    }
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("职位更新成功");
        }
        return RespBean.error("职位更新失败");
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportExcel() throws IOException {
        return POIUtils.exportExcel((List<Position>) positionService.getAllPosition(null,null).getData());

    }
    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        List<Position> list=POIUtils.parseFile(file);
//        file.transferTo(new File("E://111.xls"));
        return RespBean.ok("ok");

    }


}