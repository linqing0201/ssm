package com.lin.shop.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.lin.shop.model.User;
import com.lin.shop.service.UserService;

public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	 /*** 
     * 获取授权信息 
     */  
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findPermissionsByUserName(userName));//获取角色
		authorizationInfo.setStringPermissions(userService.findPermissionsByUserName(userName));//获取权限
		
		return authorizationInfo;
	}
	/*** 
     * 获取认证信息 
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
		User user=userService.getUserByUserName(userName);
		if(user==null){
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
				user.getUserName(),
				user.getPassword(),
				ByteSource.Util.bytes(user.getUserName()+user.getPasswordSalt()),
				getName());
		return authenticationInfo;
	}
}
