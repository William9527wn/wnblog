package com.wangning.service;

import com.wangning.entity.Role;
import com.wangning.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangning.handler.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    List<Role> getUserRolesByUserName(String name);

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    Result login(String username, String password, String code, HttpServletRequest request);

}
