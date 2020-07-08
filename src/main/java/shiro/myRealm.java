package shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class myRealm extends AuthorizingRealm {
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("自定义realm授权方法");
        TUser user = (TUser) principalCollection.getPrimaryPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermission("admin");
        //授权
        authorizationInfo.addStringPermission("ddd");
        return authorizationInfo;

    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("自定义realm认证方法");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        TUser user = new TUser();
        user.setPassword("123456");
        user.setUsername("admin");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
            //简单认证信息对象
        System.out.println(this.getName());
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
            //认证
            return authenticationInfo;
    }
}
