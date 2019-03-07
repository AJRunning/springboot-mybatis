package com.runningsss.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sun.applet.Main;

import java.io.Serializable;

/**
 * @author liqings
 * @date  2018-10-3
 */

@Getter
@Setter
public class Department implements Serializable{

    private Integer id;
    private String departmentName;



}
