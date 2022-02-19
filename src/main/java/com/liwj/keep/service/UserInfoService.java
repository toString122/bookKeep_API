package com.liwj.keep.service;

import com.liwj.keep.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author peifengli
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getUserInfoByRequest(HttpServletRequest request);

}
