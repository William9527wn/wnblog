package com.wangning.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserLoginVo
 * @Description TODO
 * @date 2022年5月12日 下午9:27
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户账号")
public class UserLoginVo {

    /**
     * 用户名
     */
    @ApiModelProperty(name = "username", value = "用户名", required = true, dataType = "String")
    private String username;

    /**
     * 密码
     */

    @ApiModelProperty(name = "password", value = "密码", required = true, dataType = "String")
    private String password;

    /**
     * 验证码
     */

    @ApiModelProperty(name = "code", value = "邮箱验证码", required = true, dataType = "String")
    private String code;

}
