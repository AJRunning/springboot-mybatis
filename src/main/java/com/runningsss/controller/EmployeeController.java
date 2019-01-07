package com.runningsss.controller;

import com.runningsss.bean.Employee;
import com.runningsss.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqings
 * @date 2018-12-04
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        Employee empById = employeeService.getEmpById(id);
        return  empById;
    }
}
