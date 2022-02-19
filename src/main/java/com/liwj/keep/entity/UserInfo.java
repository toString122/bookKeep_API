package com.liwj.keep.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info_t")
public class UserInfo {
    @TableId
    private Long id;
    private String nickName;
    private String avatarUrl;
    private Integer gender;
    private String province;
    private String city;
    private String phone;
    private String password;
    private String openId;
    private String role;

}
