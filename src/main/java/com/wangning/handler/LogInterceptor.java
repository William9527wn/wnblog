package com.wangning.handler;

import com.wangning.contants.WebContant;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @ClassName LogInterceptor
 * @Description TODO
 * @date 29/4/2022 上午10:50
 * @Version 1.0
 */
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String tid = UUID.randomUUID().toString().replace("-", "");
        MDC.put(WebContant.MDC_TRACE, tid);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        MDC.remove(WebContant.MDC_TRACE);
    }

}

