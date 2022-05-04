package com.wangning.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.wangning.entity.User;
import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import com.wangning.handler.exception.CustomException;
import com.wangning.mapper.UserMapper;
import com.wangning.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangning
 * @since 2022-04-28
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectById(id);
        if(ObjectUtil.isNotEmpty(user)){
            return user;
        }
        throw  new CustomException(ResultCode.RESULE_DATA_NONE.code(),ResultCode.RESULE_DATA_NONE.message());
    }

    @Override
    public User getUserAndRolesByName(String name) {
        log.info(name);
        User user = userMapper.getUserRolesByName(name);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
