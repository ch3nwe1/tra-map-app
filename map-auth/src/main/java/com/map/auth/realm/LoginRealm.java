package com.map.auth.realm;

import com.map.common.constant.AccountStatus;
import com.map.common.entity.system.AuthUser;
import com.map.common.mapper.system.AuthUserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 *
 * 登录认证
 *
 * @author 陈伟
 * @date 2019/7/21 17:30
 **/
public class LoginRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthUserMapper authUserMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("开始进行用户认证...");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        AuthUser user = authUserMapper.getUserByCode(username);
        if(Objects.isNull(user)){
            throw new UnknownAccountException("账户不存在");
        }
        //账户状态检查
        switch (user.getStatus()){
            case Lock: throw new LockedAccountException("账户被锁");
            case Invaild:throw new ExpiredCredentialsException("账户已失效");
            default:break;
        }

        Object principal = user;
        Object credentials = user.getPassword();
        String realmName = this.getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getCode());

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return simpleAuthenticationInfo;
    }

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("MD5", "admin", "admin", 1024);
        System.out.println(simpleHash);
    }
}
