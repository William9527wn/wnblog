package com.wangning.utils;

import com.wangning.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ClassName LoginUtil
 * @Description TODO
 * @date 2022年5月18日 下午4:27
 * @Version 1.0
 */
public class LoginUtil {
    //获取当前登录操作员
    public static User getCurrentAdmin(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
