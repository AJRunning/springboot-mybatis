package com.runningsss.mapper;

import com.runningsss.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author liqings
 * @date 2018-12-04
 */
@Mapper
public interface EmployeeMapper {


    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);
}


