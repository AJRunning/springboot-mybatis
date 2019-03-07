package com.runningsss.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liqings
 * @date 2019-02-15
 */
@Getter
@Setter
public class Sign implements Serializable {

    public Integer id;
    public String userId;
    public Date signDate;


}
