package com.wangning.dto;

import com.wangning.entity.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserRoleDto
 * @Description TODO
 * @date 4/5/2022 下午6:36
 * @Version 1.0
 */
@Data
public class UserRoleDto {

    private Integer id;

    private String username;

    private String password;

    private List<Role> roles = new ArrayList<>();
}
