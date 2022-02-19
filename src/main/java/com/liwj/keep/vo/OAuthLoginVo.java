package com.liwj.keep.vo;

import com.liwj.keep.entity.UserInfo;
import lombok.Data;

import java.io.Serializable;
@Data
public class OAuthLoginVo implements Serializable {
    private Integer code;
    private Integer oAuthType;
    private UserInfo userInfo;
}
