package com.liwj.keep.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {
    private Long id;
    private String classIcon;
    private String classBg;
    private String className;
    private String remark;
    private Integer billType;
    private Double amountOfMoney;
    private Date createDate;
    private Long userId;
}
