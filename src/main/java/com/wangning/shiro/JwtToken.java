package com.wangning.shiro;

/**
 * @ClassName JwtToken
 * @Description TODO
 * @date 4/5/2022 下午9:37
 * @Version 1.0
 */
import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt){
        this.token=jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}