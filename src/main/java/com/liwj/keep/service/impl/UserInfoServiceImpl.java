package com.liwj.keep.service.impl;

import com.liwj.keep.dao.UserInfoMapper;
import com.liwj.keep.entity.UserInfo;
import com.liwj.keep.service.Audience;
import com.liwj.keep.service.UserInfoService;
import com.liwj.keep.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author peifengli
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private Audience audience;

    @Override
    public UserInfo getUserInfoByRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        final String token = authHeader.substring(7);
        String userId = JwtTokenUtil.getUserId(token, audience.getBase64Secret());
        UserInfo userInfoSearch = new UserInfo();
        userInfoSearch.setId(Long.parseLong(userId));
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(userInfoSearch);
        UserInfo one = this.getOne(queryWrapper);
        return one;
    }
}
