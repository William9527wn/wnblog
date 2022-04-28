package com.wangning.service;

import com.wangning.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
