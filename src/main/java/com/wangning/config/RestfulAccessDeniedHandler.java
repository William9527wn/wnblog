package com.wangning.config;

/**
 * @ClassName RestfulAccessDeniedHandler
 * @Description TODO
 * @date 2022年5月13日 上午10:06
 * @Version 1.0
 */
/*
当访问接口没有权限时，自定义返回结果
 */


import com.fasterxml.jackson.databind.ObjectMapper;

import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Result bean = Result.failure(ResultCode.PERMISSION_NO_ACCESS);
        bean.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
