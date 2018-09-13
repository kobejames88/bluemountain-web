package com.bluemoutain.security;



import com.bluemoutain.po.SysFunction;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.ext.SysRoleExt;
import com.bluemoutain.service.SysRoleService;
import com.bluemoutain.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现AuthorizingRealm接口用户用户认证
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private SysRoleService roleService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取session中的用户
        SystemUser user = (SystemUser) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions = new ArrayList<>();
        SysRoleExt role = roleService.findAllFunctionByRole(user.getRole());
        List<SysFunction> functions = role.getFunctions();
        for (SysFunction function : functions) {
            permissions.add(function.getFunDescp());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }


    /**
     * 认证.登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        SystemUser login = new SystemUser();
        login.setUser(username);
        login.setPwd(password);
        SystemUser user = userService.findUserByUserNameAndPassword(login);
        return new SimpleAuthenticationInfo(user, user.getPwd(), this.getClass().getName());
    }

}
