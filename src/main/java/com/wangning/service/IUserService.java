package com.wangning.service;

import com.wangning.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangning.handler.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangning
 * @since 2022-04-28
 */
public interface IUserService extends IService<User> {
    User selectUserById(Integer id);

    User getUserAndRolesByName(String name);

    User getUserByName(String name);

    /**
     * 登录功能
     * @param username
     * @param password
     * @param request
     * @return
     */
    Result login(String username, String password, HttpServletRequest request);

}
