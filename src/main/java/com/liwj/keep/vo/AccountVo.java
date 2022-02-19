package com.liwj.keep.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author peifengli
 */
@Data
public class AccountVo implements Serializable {
    private String phone;
    private String password;
    private Integer loginType;
}
