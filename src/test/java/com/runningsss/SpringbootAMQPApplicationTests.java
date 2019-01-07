package com.runningsss;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.runningsss.bean.Employee;
import com.runningsss.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAMQPApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void create() {
        /*amqpAdmin.declareExchange(new DirectExchange("running.exchange"));
        amqpAdmin.declareQueue(new Queue("running.queue", true));*/
        amqpAdmin.declareBinding(new Binding("running.queue", Binding.DestinationType.QUEUE, "running.exchange", "running.emp", null));
    }


    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        HashMap<String, String> map = new HashMap<>();
        map.put("hello","你好呀");
        rabbitTemplate.convertAndSend("running.exchange","running.emp",map);
    }

    @Test
    public void receive(){
        Message message = rabbitTemplate.receive("running.emp");
        System.out.println(message);
    }
}
