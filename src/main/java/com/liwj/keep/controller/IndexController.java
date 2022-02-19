package com.liwj.keep.controller;

import com.liwj.keep.annotation.JwtIgnore;
import com.liwj.keep.entity.RetMessage;
import com.liwj.keep.entity.TokenData;
import com.liwj.keep.entity.UserInfo;
import com.liwj.keep.exception.CustomException;
import com.liwj.keep.service.Audience;
import com.liwj.keep.service.UserInfoService;
import com.liwj.keep.utils.JwtTokenUtil;
import com.liwj.keep.utils.ResultCode;
import com.liwj.keep.vo.AccountVo;
import com.liwj.keep.vo.EncryptedDataVo;
import com.liwj.keep.vo.OAuthLoginVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.spec.AlgorithmParameterSpec;

@RestController
public class IndexController {
    private static Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private Audience audience;
    @Autowired
    private UserInfoService userInfoService;

    @JwtIgnore
    @PostMapping("/account/login")
    public RetMessage login(@RequestBody AccountVo accountVo) {
        RetMessage retMessage = new RetMessage();
        UserInfo userInfoSearch = new UserInfo();
        userInfoSearch.setPhone(accountVo.getPhone());
        userInfoSearch.setPassword(accountVo.getPassword());
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(userInfoSearch);
        UserInfo one = userInfoService.getOne(queryWrapper);
        if (null == one) {
            retMessage.setResult(false);
            retMessage.put("msg", "用户名密码错误");
            return retMessage;
        }
        TokenData tokenData = getTokenData(one);
        retMessage.setData(tokenData);
        retMessage.setResult(true);
        return retMessage;
    }

    @JwtIgnore
    @PostMapping("/account/oAuthLogin")
    public RetMessage oAuthLogin(@RequestBody OAuthLoginVo oAuthLoginVo) {
        System.out.println(oAuthLoginVo.getUserInfo().getNickName());
        //根据openId获取用户信息，如果不存在，那么就直接存储进去
        UserInfo userInfoSearch = new UserInfo();
        userInfoSearch.setOpenId(oAuthLoginVo.getUserInfo().getOpenId());
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(userInfoSearch);
        UserInfo one = userInfoService.getOne(queryWrapper);
        if (null == one) {
            userInfoService.save(oAuthLoginVo.getUserInfo());
        }
        RetMessage retMessage = new RetMessage();
        TokenData tokenData = getTokenData(one);
        retMessage.setData(tokenData);
        retMessage.setResult(true);
        return retMessage;
    }

    private TokenData getTokenData(UserInfo one) {
        TokenData tokenData = new TokenData();
        String jwt = JwtTokenUtil.createJWT(String.valueOf(one.getId()), one.getNickName(), one.getRole(), audience);
        tokenData.setAccessToken(jwt);
        Audience audience2 = new Audience();
        audience2.setClientId(audience.getClientId());
        audience2.setExpiresSecond(60 * 60 * 24 * 30);
        audience2.setName(audience.getName());
        audience2.setBase64Secret(audience.getBase64Secret());
        String jwtRefresh = JwtTokenUtil.createJWT(String.valueOf(one.getId()), one.getNickName(), one.getRole(), audience2);
        tokenData.setRefreshToken(jwtRefresh);
        return tokenData;
    }

    @JwtIgnore
    @PostMapping("/account/refreshToken")
    public RetMessage refreshToken(@RequestParam("token") String refreshToken) {
        //判断当前token是否过期了，如果过期的话，前端拿refreshToken换个新的token
        RetMessage retMessage = new RetMessage();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(audience.getBase64Secret()))
                    .parseClaimsJws(refreshToken).getBody();
            String username = JwtTokenUtil.getUsername(refreshToken, audience.getBase64Secret());
            String userId = JwtTokenUtil.getUserId(refreshToken, audience.getBase64Secret());
            //TODO: 根据用户名获取用户信息，再写入到token中返回
            UserInfo userInfoSearch = new UserInfo();
            userInfoSearch.setId(Long.parseLong(userId));
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.setEntity(userInfoSearch);
            UserInfo one = userInfoService.getOne(queryWrapper);
            TokenData tokenData = getTokenData(one);
            retMessage.setData(tokenData);
        } catch (ExpiredJwtException eje) {
            log.error("===== Token过期 =====", eje);
            throw new CustomException(ResultCode.REFRESH_PERMISSION_TOKEN_EXPIRED);
        } catch (Exception ex) {
            throw new CustomException(ResultCode.REFRESH_PERMISSION_TOKEN_INVALID);
        }
        retMessage.setResult(true);
        return retMessage;
    }

    @PostMapping("/account/bindPhone")
    public RetMessage bindPhone(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        RetMessage retMessage = new RetMessage();
        try {
            UserInfo userInfoSession = userInfoService.getUserInfoByRequest(request);
            userInfoSession.setPhone(userInfo.getPhone());
            userInfoSession.setPhone(userInfo.getNickName());
            userInfoSession.setPhone(userInfo.getPhone());
            userInfoService.updateById(userInfoSession);
            retMessage.setData("绑定成功");
        } catch (Exception ex) {
            retMessage.setResult(false);
            retMessage.put("msg", "绑定失败");
            return retMessage;
        }
        retMessage.setResult(true);
        return retMessage;
    }

    @PostMapping("/account/getPhone")
    public RetMessage getPhone(@RequestBody EncryptedDataVo encryptedDataVo, HttpServletRequest request) {
        RetMessage retMessage = new RetMessage();
        try {
            byte[] encrypData = Base64.decode(encryptedDataVo.getEncryptedData());
            byte[] ivData = Base64.decode(encryptedDataVo.getIv());
            byte[] sessionKey = Base64.decode(encryptedDataVo.getSessionKey());
            String str = "";
            try {
                str = decrypt(sessionKey, ivData, encrypData);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(str);
            JSONObject jsonObject = JSON.parseObject(str);
            //绑定给用户
            String phoneNumber = jsonObject.getString("phoneNumber");
            UserInfo userInfo = userInfoService.getUserInfoByRequest(request);
            userInfo.setPhone(phoneNumber);
            userInfoService.updateById(userInfo);
            retMessage.setData(jsonObject);
        } catch (Exception ex) {

        }
        retMessage.setResult(true);
        return retMessage;
    }

    public static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串
        return new String(cipher.doFinal(encData), "UTF-8");
    }


    @PostMapping("/account/getUserInfo")
    public RetMessage getUserInfo(HttpServletRequest request) {
        RetMessage retMessage = new RetMessage();
        //获取token
        retMessage.setData(userInfoService.getUserInfoByRequest(request));
        retMessage.setResult(true);
        return retMessage;
    }



}
