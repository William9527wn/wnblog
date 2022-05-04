package com.wangning.shiro;

import com.wangning.dto.UserRoleDto;
import com.wangning.entity.Role;
import com.wangning.entity.User;
import com.wangning.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName LoginRealm
 * @Description TODO
 * @date 4/5/2022 下午9:48
 * @Version 1.0
 */
@Component
@Slf4j
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        获取对象用户名
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("权限授权用户："+primaryPrincipal);
        User login = this.userService.login(primaryPrincipal);
        if (!ObjectUtils.isEmpty(login)) {
//            查询用户角色
            User user = this.userService.getUserAndRolesByName(login.getUsername());

            Set<String> roles = new HashSet<>();
            for (Role role: user.getRoles()) {
                roles.add(role.getRoleName());
            }

//            System.out.println("角色权限："+perms);
//            查询角色权限(如果不使用set集合会出现重复权限 set可以去重 当然底层也是set)
//            Set<String> roles = this.userService.getRolesByUserId(login.getId());
            System.out.println("用户角色："+roles);
//            创建授权器
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//            传入授权角色
            simpleAuthorizationInfo.setRoles(roles);
//            传入授权角色操作
//            simpleAuthorizationInfo.setStringPermissions(perms);
//            返回
            return simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 登录拦截
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        查询到用户名
//        String authenticationToken= (String) token.getCredentials();
        String principal = (String) token.getPrincipal();
//        数据库查询
        User user = userService.login(principal);
        if (user == null) {
            throw new UnknownAccountException();
        }
//        判断对象是否为空
        if (!ObjectUtils.isEmpty(user)) {
//           传入密码md5+salt随机盐
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,user.getPassword(),
//                    ByteSource.Util.bytes(user.getSalt()),getName());
//            返回
            return new SimpleAuthenticationInfo(user, user.getPassword(), "");
        }
        return null;
    }
}
