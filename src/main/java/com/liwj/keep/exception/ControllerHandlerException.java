package com.liwj.keep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandlerException {
    // 在这个方法里定义我们需要返回的格式
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerUserNotExistException(CustomException ex, HttpServletResponse httpServletResponse) {
        Map<String, Object> result = new HashMap<>();
        //获取到我们定义的code
        result.put("code", ex.getCode());
        //获取到我们定义的msg
        result.put("msg", ex.getMsg());
        if (null != ex.getCode()) {
            httpServletResponse.setStatus(ex.getCode());
        }else{
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return result;
    }
}
