package com.runningsss.mapper;

import com.github.pagehelper.Page;
import com.runningsss.bean.Department;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

/**
 * @author liqings
 * @date 2018-10-03
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department")
    public Page<Department> list();

    @Select("select * from department where id =#{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delete from department where id =#{id}")
    public int delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert department (departmentName) values(#{departmentName})")
    public int insert(Department department);

    @Update("update department set departmentName = #{departmentName} where id =#{id}")
    public int update(Department department);
}
