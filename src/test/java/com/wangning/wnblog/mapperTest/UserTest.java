package com.wangning.wnblog.mapperTest;


import com.wangning.mapper.UserMapper;
import com.wangning.service.IUserService;
import com.wangning.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserTest
 * @Description TODO
 * @date 4/5/2022 下午7:29
 * @Version 1.0
 */
@SpringBootTest
public class UserTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void selectUser(){
        System.out.println(userService.getUserByName("admin"));
    }
}
