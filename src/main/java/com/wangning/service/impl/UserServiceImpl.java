package com.wangning.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.wangning.config.security.JwtTokenUtil;
import com.wangning.entity.Role;
import com.wangning.entity.User;
import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import com.wangning.handler.exception.CustomException;
import com.wangning.mapper.UserMapper;
import com.wangning.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
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
        return userMapper.getUserRolesByName(name);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public List<Role> getUserRolesByUserName(String name) {
        return userMapper.getUserRolesByUserName(name);
    }

    @Override
    public Result login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        log.info(captcha+"***********"+ code);
        if(StrUtil.isEmpty(captcha) || !captcha.equalsIgnoreCase(code)){
            return Result.failure(ResultCode.USER_LOGIN_CAPTCHA_ERROR);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        log.info(JSONUtil.toJsonStr(userDetails.getPassword()+ "--------------"+ password));
        if (null==userDetails||!passwordEncoder.matches(password,passwordEncoder.encode(userDetails.getPassword()))){
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        }
        if (!userDetails.isEnabled()){
            return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                ,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return Result.success(tokenMap);
    }

}
