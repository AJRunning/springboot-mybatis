package com.runningsss;

import com.runningsss.bean.Department;
import com.runningsss.bean.Employee;
import com.runningsss.mapper.DepartmentMapper;
import com.runningsss.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RedisTemplate myRedisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testStringRedis() {
        stringRedisTemplate.opsForValue().set("msg","hello my friend!");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void testRedis() {

        Department departmentById = departmentMapper.getDepartmentById(4);
        /*redisTemplate.opsForValue().set("dept1",departmentById);*/
        myRedisTemplate.opsForValue().set("dept2",departmentById);
        Employee empById = employeeMapper.getEmpById(1);
        myRedisTemplate.opsForValue().set("emp1",empById);

    }
}
