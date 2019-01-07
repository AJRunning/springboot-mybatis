package com.runningsss.controller;

import com.runningsss.bean.Department;
import com.runningsss.mapper.DepartmentMapper;
import com.runningsss.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqings
 * @date 2018-10-03
 */
@RestController
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;


    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id){
        return  departmentService.getDepartmentById(id);
    }

    @GetMapping("/dept/add")
    public Department insert(Department department){
        departmentService.insertDepartment(department);
        return  department;
    }

    @GetMapping("/dept/del")
    public String delete(Integer id){
        departmentService.deleteDept(id);
        return "success";
    }
}
