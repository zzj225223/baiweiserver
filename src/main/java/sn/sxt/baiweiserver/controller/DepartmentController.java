package sn.sxt.baiweiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.sxt.baiweiserver.bean.Department;
import sn.sxt.baiweiserver.bean.RespBean;
import sn.sxt.baiweiserver.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
     @GetMapping("/")
    public List<Department> getAllDepts(){

         return departmentService. getAllDepts();
    }
    @PostMapping("/")
    public RespBean addDep(@RequestBody Department department){
         departmentService.addDep(department);
         if (department.getResult()==1){
            return RespBean.ok("添加成功",department);
         }
         return RespBean.error("添加失败");

    }
    @GetMapping("/all")
    public List<Department> getAllDepartments(){
         return  departmentService.getAllDepartments();
    }


    @DeleteMapping("/{id}")
    public RespBean deleteDepartmentById(@PathVariable Integer id){
         Department department=new Department();
         department.setId(id);
         departmentService.deleteDepartmentById(department);
         if (department.getResult()==-2){
             return RespBean.error("父部门，无法删除");
         }else if(department.getResult()==-1){
             return  RespBean.error("该部门下有员工，无法删除");
        }else if (department.getResult()==1){
             return RespBean.ok("删除成功");
         }else {
             return  RespBean.error("删除失败");
         }
    }
}
