package com.wangning.controller;


import cn.hutool.core.util.ObjectUtil;
import com.wangning.entity.User;
import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import com.wangning.service.IUserService;
import com.wangning.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangning
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/select")
    @ResponseBody
    public Result selectUserById(){
        User user = userService.selectUserById(4);
        if(ObjectUtil.isNotEmpty(user)){
            return Result.success(user);
        }
        return Result.failure(ResultCode.RESULE_DATA_NONE);
    }
}
