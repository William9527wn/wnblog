package com.wangning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangning.mapper")
public class WnblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WnblogApplication.class, args);
    }

}
