package com.wangning.controller;

import com.wangning.entity.User;
import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import com.wangning.service.IUserService;
import com.wangning.vo.UserLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @ClassName LoginController
 * @Description TODO
 * @date 2022年5月12日 下午9:31
 * @Version 1.0
 */
@RestController
@Api(value = "登录功能")
public class LoginController {

}
