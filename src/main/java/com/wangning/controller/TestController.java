package com.wangning.controller;

import cn.hutool.core.util.ObjectUtil;
import com.wangning.entity.User;
import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import com.wangning.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @date 2022年5月13日 上午10:14
 * @Version 1.0
 */
@RestController
@Api(value = "测试模块")
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("根据id查询用户")
    public Result getUserByName(){
        User user = userService.getUserByName("admin");
        log.info("测试");
        if(ObjectUtil.isNotEmpty(user)){
            return Result.success(user);
        }
        return Result.failure(ResultCode.RESULE_DATA_NONE);
    }
}
