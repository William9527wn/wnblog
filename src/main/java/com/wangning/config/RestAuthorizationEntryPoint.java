package com.wangning.config;

/**
 * @ClassName RestAuthorizationEntryPoint
 * @Description TODO
 * @date 2022年5月13日 上午10:04
 * @Version 1.0
 */
/*
当未登录或者token失效时访问接口，自定义的返回结果
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Result bean = Result.failure(ResultCode.USER_NOT_LOGGED_IN);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
