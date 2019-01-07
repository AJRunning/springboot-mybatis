package com.runningsss.service;

import com.runningsss.bean.Employee;
import com.runningsss.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author liqings
 * @date 2018-12-04
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Qualifier("myCacheManager")
    @Autowired
    RedisCacheManager myCacheManager;

    public Employee getEmpById(Integer id) {
        System.out.println("查询员工" + id);
        Employee empById = employeeMapper.getEmpById(id);
        Cache emp = myCacheManager.getCache("emp");
        emp.put("emp" + id, empById);
        return empById;
    }

}
