package com.wangning.controller;


import io.swagger.annotations.Api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;


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
@Api(tags = "用户管理")
@RequestMapping("/user")
@Slf4j
public class UserController {

}
