package com.runningsss.bean;

import java.io.Serializable;

/**
 * @author liqings
 * @date  2018-10-3
 */
public class Department implements Serializable{

    private Integer id;
    private String departmentName;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
